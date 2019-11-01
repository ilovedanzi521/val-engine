/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/10:08
 * 项目名称: dfbp-val-engine
 * 文件名称: BondTradeStrategy.java
 * 文件描述: @Description: 债券交易策略
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.core.strategy.impl;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.val.cal.ISecurityCalculation;
import com.win.dfbp.val.common.constant.RedisKeyPrefix;
import com.win.dfbp.val.common.constant.TradeRuleConstant;
import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityIndexVO;
import com.win.dfbp.val.common.entity.SecurityParam;
import com.win.dfbp.val.core.entity.CalculationItem;
import com.win.dfbp.val.core.entity.CalculationValClass;
import com.win.dfbp.val.core.factory.SpiFactory;
import com.win.dfbp.val.core.strategy.BaseStrategy;
import com.win.dfbp.val.core.util.MathExpress;
import com.win.dfbp.val.core.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 包名称：com.win.dfbp.strategy.impl
 * 类名称：BondTradeStrategy
 * 类描述：债券交易策略
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/10:08
 */
@Service
@Slf4j
public class BondTradeStrategy extends BaseStrategy {
    @Override
    public SecurityIndexVO calInitIndex(SecurityParam securityParam) {
        securityParam.setInvestFlag(securityIndex.getInvestFlag());
        //1计算持仓成本
        //初次持仓，交易金额=持仓成本
        securityParam.setPositionAmount(securityIndex.getStockSettleAmount());

        return calIndex(null,securityParam,true);
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
        MathExpress me = new MathExpress(calModel,5,RoundingMode.HALF_EVEN);
        return new BigDecimal(me.caculate());
    }


    @Override
    public SecurityIndexVO calPositionIndex(SecurityIndex oldIndex, SecurityParam securityParam) {
        securityParam.setInvestFlag(securityIndex.getInvestFlag());
        //持仓数量
        BigDecimal positionAmount = ServiceUtil.calAmount(oldIndex.getIndexVO().getPositionAmount(),
                securityIndex.getStockSettleAmount(),securityIndex.getTradeDirection());
        securityParam.setPositionAmount(positionAmount);
        //持仓成本
        return calIndex(oldIndex,securityParam,false);
    }

    /**
     * @Title: calIndex
     * @Description 计算逻辑
     * @param oldIndex
     * @param securityParam
     * @param isInit
     * @return com.win.dfbp.entity.SecurityIndexVO
     * @throws
     * @author wanglei
     * @Date 2019/10/25/11:26
     */
    public SecurityIndexVO calIndex(SecurityIndex oldIndex,SecurityParam securityParam,boolean isInit) {
        //获取产品配置的对应的
        SecurityIndexVO indexVO = new SecurityIndexVO();
        //context上下文用于计算表达式，使用替换
        Map<String,Object> context = new HashMap<String,Object>();
        //计算计算因子
        calItems(securityParam,indexVO,context);
        //指标计算开始
        //Redis获取计算指标
        String fundNo = securityIndex.getFundNo();
        List<CalculationValClass> calList = ServiceUtil.queryFundClass(fundNo);
        //计算项计算
        calClasses(calList,securityParam,oldIndex,indexVO,context,isInit);
        securityIndex.setIndexVO(indexVO);
        return indexVO;
    }
    /**
     * @Title: calClasses
     * @Description 计算项计算
     * @param calList redis缓存中获取的产品对应的估值分类列表
     * @param securityParam 计算参数
     * @param oldIndex 原持仓信息
     * @param indexVO 新的交易数据
     * @param context context上下文，用于计算公式，直接从map中获取计算的结果
     * @param isInit 是否存在持仓历史记录
     * @return void
     * @throws
     * @author wanglei
     * @Date 2019/10/31/18:43
     */
    private void calClasses(List<CalculationValClass> calList,SecurityParam securityParam,SecurityIndex oldIndex, SecurityIndexVO indexVO, Map<String, Object> context,boolean isInit) {
        for (CalculationValClass calculationItem : calList) {
            //指标分类
            String classCode = calculationItem.getClassCode();
            //计算公式或计算模型
            String calModel = calculationItem.getCalModel();
            //如果是计算模型VAL_CAL_TYPE_1
            BigDecimal calResult = BigDecimal.ZERO;
            if(TradeRuleConstant.VAL_CAL_TYPE_1==calculationItem.getCalType()){
                ISecurityCalculation securityCalculation = SpiFactory.getSecurityAlgorithm(calModel);
                if(isInit){
                    calResult = securityCalculation.cal(securityParam);
                }else{
                    calResult = securityCalculation.cal(oldIndex,securityParam);
                }
                //放入map用来计算
                context.put(classCode,calResult);
                //放入指标中
            }
            //如果是计算公式
            if(TradeRuleConstant.VAL_CAL_TYPE_2==calculationItem.getCalType()){
                //解析表达式
                calResult = calFormula(context,calModel);
                context.put(classCode,calResult);
            }
            indexVO.setIndex(classCode,calResult);
        }
    }

    /**
     * @Title: calItems
     * @Description 计算计算因子
     * @param securityParam
     * @param indexVO
     * @param context
     * @return void
     * @throws
     * @author wanglei
     * @Date 2019/10/31/18:35
     */
    private void calItems(SecurityParam securityParam, SecurityIndexVO indexVO, Map<String, Object> context) {
        //所含税
        securityParam.setTradeRates(securityIndex.getTradeRates());
        //交易金额
        securityParam.setCashSettleBalance(securityIndex.getCashSettleBalance());
        //交易数量
        securityParam.setStockSettleAmount(securityIndex.getStockSettleAmount());
        //交易方向
        securityParam.setTradeDirection(securityIndex.getTradeDirection());
        //获取价格和百元利息
        securityParam.calPrice().calInterest();

        //计算项计算开始
        //redis获取计算项
        String itemKey = RedisKeyPrefix.CAL_ITEM+CommonConstants.HORIZONTAL_LINE+"*";
        //获取指标list
        List<Object> items = RedisUtil.matchGet(itemKey);
        //迭代计算
        for (Object item : items) {
            CalculationItem calculationItem = JSON.parseObject(JSON.toJSONString(item),CalculationItem.class);
            String code = calculationItem.getCalItem();
            //计算结果放入到map中,用于计算
            BigDecimal value = securityParam.getCalculationItemValue(code);
            context.put(code,value);
            indexVO.setIndex(code,value);
        }
    }

}
