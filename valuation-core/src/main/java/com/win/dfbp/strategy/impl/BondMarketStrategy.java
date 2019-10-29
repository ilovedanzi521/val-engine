/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-17/16:58
 * 项目名称: dfbp-fa-engine
 * 文件名称: BondMarketStrategy.java
 * 文件描述: @Description: 行情--债券数据指标更新策略类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.strategy.impl;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.cal.ISecurityCalculation;
import com.win.dfbp.constant.InvestFlagConstant;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.TradeRuleConstant;
import com.win.dfbp.entity.*;
import com.win.dfbp.factory.SpiFactory;
import com.win.dfbp.strategy.BaseMarketStrategy;
import com.win.dfbp.util.MathExpress;
import org.apache.flink.api.java.io.jdbc.JDBCOutputFormat;
import org.apache.flink.types.Row;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.sql.Types.*;

/**
 * 包名称：com.win.dfbp.strategy.impl
 * 类名称：BondMarketStrategy
 * 类描述：行情--债券数据指标更新策略类
 * 创建人：@author zoujian
 * 创建时间：2019-10-17/16:58
 */
@Service
public class BondMarketStrategy extends BaseMarketStrategy {
    @Autowired
    private Properties dataSourceProperties;

    @Override
    public SecurityParam calPositionIndex(ValMarket valMarket,  SecurityParam securityParam) {
        // 3、判断是否持仓
        // 持仓缓存存储格式 eg: VAL_POSITION-010107-SH-
        List<Object> positionList = RedisUtil.matchGet(RedisKeyPrefix.VAL_POSITION + CommonConstants.HORIZONTAL_LINE + valMarket.getSecurityCode()  + valMarket.getMarketCode()
                + (securityParam.getSecurityCharacter() == null ? "" : securityParam.getSecurityCharacter()) + CommonConstants.ASTERISK);

        if(positionList != null){
            // 净价
            BigDecimal netPrice = new BigDecimal(valMarket.getNetPrice());
            securityParam.setNetPrice(netPrice);
            // 全价
            BigDecimal fullPrice = new BigDecimal(valMarket.getFullPrice());
            securityParam.setFullPrice(fullPrice);
            for (Object ob: positionList){
                ValPosition valPosition = JSON.parseObject(JSON.toJSONString(ob),ValPosition.class);
                BeanUtils.copyProperties(valPosition,securityParam);
                String investFlag = valPosition.getInvestFlag();
                securityParam.setInvestFlag(investFlag);
                if(InvestFlagConstant.FLAG_C.equals(investFlag) || InvestFlagConstant.FLAG_Y.equals(investFlag)){
                    // 投资标志为：持有到期、贷款应收款的债券 不计算其相应的指标
                    continue;
                }
                // 4、匹配估值标准 获取估值标准、小数精度、估价来源等
                securityParam.setSecurityParam(valPosition.getFundNo());
                if(!valMarket.getDataSource().equals(securityParam.getSource())){
                    // 行情估值来源不同于估值标准的估值来源 跳过计算
                    continue;
                }

                //context上下文用于计算表达式，使用替换
                Map<String,Object> context = new HashMap<String,Object>();
                //计算项计算开始
                //redis获取计算项
                String itemKey = RedisKeyPrefix.CAL_ITEM + CommonConstants.HORIZONTAL_LINE + "*";
                //获取指标list
                List<Object> items = RedisUtil.matchGet(itemKey);
                for (Object item : items) {
                    CalculationItem calculationItem = JSON.parseObject(JSON.toJSONString(item),CalculationItem.class);
                    String code = calculationItem.getCalItem();
                    //计算结果放入到map中,用于计算
                    context.put(code,securityParam.getCalculationItemValue(code));
                }

                // 获取产品配置信息 进行具体指标的计算
                //Redis获取计算指标
                String fundNo = valPosition.getFundNo();
                String pattern = RedisKeyPrefix.FUND_VAL_CLASS_CONFIG + CommonConstants.HORIZONTAL_LINE + fundNo+"*";
                //获取指标list
                List<Object> list = RedisUtil.matchGet(pattern);
                // 排序
                List<CalculationValClass> calList = new ArrayList<>();
                for (Object object : list) {
                    CalculationValClass calculationItem =JSON.parseObject(JSON.toJSONString(object),CalculationValClass.class);
                    calList.add(calculationItem);
                    //排序
                    Collections.sort(calList);
                }
                //迭代计算
                for (Object object : calList) {
                    CalculationValClass calculationItem =JSON.parseObject(JSON.toJSONString(object),CalculationValClass.class);
                    //指标分类
                    String classCode = calculationItem.getClassCode();
                    //计算公式或计算模型
                    String calModel = calculationItem.getCalModel();
                    //如果是计算模型VAL_CAL_TYPE_1
                    BigDecimal calResult = BigDecimal.ZERO;
                    if(TradeRuleConstant.VAL_CAL_TYPE_1 == calculationItem.getCalType()){
                        ISecurityCalculation securityCalculation = SpiFactory.getSecurityAlgorithm(calModel);
                        calResult = securityCalculation.cal(securityParam);
                        //放入map用来计算
                        context.put(classCode,calResult);
                        //放入指标中
                    }
                    //如果是计算公式
                    if(TradeRuleConstant.VAL_CAL_TYPE_2 == calculationItem.getCalType()){
                        //解析表达式
                        calResult = calFormula(context,calModel);
                        context.put(classCode,calResult);
                    }
                }
                updateValPosition(securityParam);
            }
        }
        return securityParam;
    }

    /**
     * @Title: calFormula
     * @Description 按公式解析计算
     * @param context
     * @param calModel
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/24/18:09
     */
    private BigDecimal calFormula(Map<String, Object> context, String calModel) {
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            calModel=calModel.replaceAll(entry.getKey(), String.valueOf(entry.getValue()));
        }
        MathExpress me = new MathExpress(calModel,5, RoundingMode.HALF_EVEN);
        return new BigDecimal(me.caculate());
    }

    /**
     * 更新val_position
     * @Title: updateValPosition
     * @param securityParam
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-25/13:27
     */
    private void updateValPosition(SecurityParam securityParam){
        String driverClassName = dataSourceProperties.getProperty("driverClassName");
        String url = dataSourceProperties.getProperty("url");
        String username = dataSourceProperties.getProperty("username");
        String password = dataSourceProperties.getProperty("password");
        String query = "update val_position set fair_price = ? , position_market_value = ? , floating_pl= ?, original_price = ? where security_code = ? and market_code = ?" +
                "and fund_no = ? and portf_no = ?  and invest_flag = ? ";
        //  参数数据类型
        int[] sqlTypes = {DECIMAL,DECIMAL,DECIMAL,DECIMAL,VARCHAR,VARCHAR,VARCHAR,VARCHAR,VARCHAR};
        JDBCOutputFormat jdbcOutputFormat = JDBCOutputFormat.buildJDBCOutputFormat()
                .setDrivername(driverClassName)
                .setDBUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setQuery(query)
                .setSqlTypes(sqlTypes)
                .finish();
        Row rowComb = new Row(sqlTypes.length);
        rowComb.setField(0,securityParam.getFairPrice());
        rowComb.setField(1,securityParam.getPositionMarketValue());
        rowComb.setField(2,securityParam.getFloatingPL());
        rowComb.setField(3,securityParam.getOriginalPrice());
        rowComb.setField(4,securityParam.getSecurityCode());
        rowComb.setField(5,securityParam.getMarketCode());
        rowComb.setField(6,securityParam.getFundNo());
        rowComb.setField(7,securityParam.getPortfNo());
        rowComb.setField(8,securityParam.getInvestFlag());
        try {
            jdbcOutputFormat.open(0,1);
            jdbcOutputFormat.writeRecord(rowComb);
            jdbcOutputFormat.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
