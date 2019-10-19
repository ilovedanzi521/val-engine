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

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.InvestFlagConstant;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.TradeRuleConstant;
import com.win.dfbp.constant.ValPositionConstant;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.entity.ValMarket;
import com.win.dfbp.strategy.BaseMarketStrategy;
import com.win.dfbp.strategy.fairprice.FairPriceFactory;
import com.win.dfbp.strategy.positioncost.PositionCostFactory;
import com.win.dfbp.strategy.positionmarketvalue.PositionMarketValueFactory;
import com.win.dfbp.util.RedisServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

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
    private PositionCostFactory positionCostFactory;

    @Autowired
    private FairPriceFactory fairPriceFactory;

    @Autowired
    private PositionMarketValueFactory positionMarketValueFactory;

    @Override
    public SecurityParam calPositionIndex(ValMarket valMarket,  SecurityParam securityParam) {
        // 3、判断是否持仓
        // 持仓缓存存储格式 eg: VAL_POSITION-010107-SH-
        List<Object> positionList = RedisUtil.matchGet(RedisKeyPrefix.VAL_POSITION + CommonConstants.HORIZONTAL_LINE
                + valMarket.getSecurityCode() + CommonConstants.HORIZONTAL_LINE + valMarket.getMarketCode() + CommonConstants.ASTERISK);

        if(positionList != null){
            // 净价
            BigDecimal netPrice = new BigDecimal(valMarket.getNetPrice());
            // 全价
            BigDecimal fullPrice = new BigDecimal(valMarket.getFullPrice());
            for (Object ob: positionList){
                LinkedHashMap positionMap = (LinkedHashMap) ob;
                String investFlag = (String) positionMap.get(ValPositionConstant.INVEST_FLAG);
                if(InvestFlagConstant.FLAG_C.equals(positionMap.get(ValPositionConstant.INVEST_FLAG).toString())||
                        InvestFlagConstant.FLAG_Y.equals(investFlag)){
                    // 投资标志为：持有到期、贷款应收款的债券 不计算其相应的指标
                    continue;
                }
                // 4、匹配估值标准 获取估值标准、小数精度、估价来源等
                securityParam.setSecurityParam();
                if(!valMarket.getDataSource().equals(securityParam.getSource())){
                    // 行情估值来源不同于估值标准的估值来源 跳过计算
                    continue;
                }

                // 获取估值标准
                String valCriteria = RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_VAL_SCHEME,
                        positionMap.get(ValPositionConstant.FUND_NO).toString(),"valCriteria");
                // 计算公允价格
                BigDecimal fairPrice = fairPriceFactory.getInstance(valCriteria).cal(securityParam);
                securityParam.setFairPrice(fairPrice);

                // 获取成本转结方式
                String costAccount= RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_CONFIG +
                                CommonConstants.HORIZONTAL_LINE +
                                positionMap.get(ValPositionConstant.FUND_NO).toString(),
                        TradeRuleConstant.VAL_PARAM_DIC_FP001,"methodCode");
                // 计算持仓成本
                BigDecimal positionCost = positionCostFactory.getInstance(costAccount).cal(securityParam);
                securityParam.setPositionCost(positionCost);

                // 持仓市值
                BigDecimal positionMarketValue = positionMarketValueFactory.getInstance(investFlag).cal(securityParam);
                securityParam.setPositionMarketValue(positionMarketValue);

                // 浮动盈亏
                securityParam.setFloatingPL(positionMarketValue.subtract(positionCost));
            }
        }
        return null;
    }
}
