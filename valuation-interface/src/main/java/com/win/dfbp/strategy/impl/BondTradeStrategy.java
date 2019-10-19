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

package com.win.dfbp.strategy.impl;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.TradeRuleConstant;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.strategy.BaseStrategy;
import com.win.dfbp.strategy.fairprice.FairPriceFactory;
import com.win.dfbp.strategy.positioncost.PositionCostFactory;
import com.win.dfbp.strategy.positionmarketvalue.PositionMarketValueFactory;
import com.win.dfbp.util.RedisServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    @Autowired
    private PositionMarketValueFactory positionMarketValueFactory;
    @Autowired
    private PositionCostFactory positionCostFactory;
    @Autowired
    private FairPriceFactory fairPriceFactory;

    ;

    @Override
    public SecurityIndexVO calInitIndex(SecurityParam securityParam) {

        SecurityIndexVO indexVO = new SecurityIndexVO();

        //2.获取成本转结方式
        String costAccount= RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_CONFIG+
                        CommonConstants.HORIZONTAL_LINE+
                        securityIndex.getFundNo(),
                TradeRuleConstant.VAL_PARAM_DIC_FP001,"methodCode");
        //持仓成本
        securityParam.setPositionCost(securityIndex.getStockSettleAmount());
        //1计算持仓成本
        //初次持仓，交易金额=持仓成本
        securityParam.setPositionAmount(securityIndex.getCashSettleBalance());
        indexVO.setPositionAmount(securityIndex.getCashSettleBalance());
        BigDecimal positionCost = positionCostFactory.getInstance(costAccount).cal(securityParam);
        //成本价格=持仓成本/持仓数量
        indexVO.setCostPrice(positionCost.divide(securityParam.getPositionAmount(),
                securityParam.getDecimalAccuracy(), RoundingMode.HALF_EVEN));
        indexVO.setPositionCost(positionCost);
        //2.获取估值参数
        String valCriteria = securityParam.getValCriteria();
        //计算公允价格
        BigDecimal fairPrice = fairPriceFactory.getInstance(valCriteria).calFairPrice(securityParam);
        //返回设置公允价格
        indexVO.setFairPrice(fairPrice);
        //证券信息设置公允价格
        securityParam.setFairPrice(fairPrice);
        //3.获取投资标志
        String investFlag= securityIndex.getInvestFlag();
        //计算持仓市值
        BigDecimal positionMarketValue = positionMarketValueFactory.getInstance(investFlag).cal(securityParam);
        indexVO.setPositionMarketValue(positionMarketValue);
        //浮动盈亏=持仓市值-持仓成本
        indexVO.setFloatingPL(positionMarketValue.subtract(positionCost));
        securityIndex.setIndexVO(indexVO);
        return indexVO;
    }

    @Override
    public SecurityIndexVO calPositionIndex(SecurityIndex oldIndex,SecurityParam securityParam) {
        SecurityIndexVO indexVO = new SecurityIndexVO();
        //持仓数量
        BigDecimal positionAmount = securityIndex.getCashSettleBalance().add(oldIndex.getIndexVO().getPositionAmount());
        securityParam.setPositionAmount(positionAmount);
        indexVO.setPositionAmount(positionAmount);
        //持仓成本
        securityParam.setPositionCost(securityIndex.getStockSettleAmount().add(oldIndex.getIndexVO().getPositionCost()));
        //计算公允价格
        BigDecimal fairPrice = oldIndex.getIndexVO().getFairPrice();
        indexVO.setFairPrice(fairPrice);
        securityParam.setFairPrice(fairPrice);
        //2.获取成本转结方式
        String costAccount= RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_CONFIG+
                        CommonConstants.HORIZONTAL_LINE+
                        securityIndex.getFundNo(),
                TradeRuleConstant.VAL_PARAM_DIC_FP001,"methodCode");
        //计算持仓成本
        BigDecimal positionCost = positionCostFactory.getInstance(costAccount).cal(securityParam);
        indexVO.setPositionCost(positionCost);
        //3.获取投资标志
        String investFlag= securityIndex.getInvestFlag();
        //计算持仓市值
        BigDecimal positionMarketValue = positionMarketValueFactory.getInstance(investFlag).cal(securityParam);
        indexVO.setPositionMarketValue(positionMarketValue);
        //持仓成本/持仓数量
        indexVO.setCostPrice(positionCost.divide(indexVO.getPositionAmount(),
                securityParam.getDecimalAccuracy(), RoundingMode.HALF_EVEN));
        //浮动盈亏=持仓市值-持仓成本
        indexVO.setFloatingPL(positionMarketValue.subtract(positionCost));
        securityIndex.setIndexVO(indexVO);
        return indexVO;
    }

}
