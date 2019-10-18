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

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.TradeRuleConstant;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.strategy.BaseStrategy;
import com.win.dfbp.strategy.fairprice.FairPriceFactory;
import com.win.dfbp.strategy.positioncost.PositionCostFactory;
import com.win.dfbp.strategy.positionmarketvalue.PositionMarketValueFactory;
import com.win.dfbp.util.RedisServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

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
    public SecurityIndexVO calInitIndex() {

        SecurityIndexVO indexVO = new SecurityIndexVO();
        //1.获取估值参数
        String valCriteria = RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_VAL_SCHEME,
                securityIndex.getFundNo(),"valCriteria");
        //计算公允价格
        BigDecimal fairPrice = fairPriceFactory.getInstance(valCriteria).cal(securityIndex);
        //2.获取成本转结方式
        String costAccount= RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_CONFIG+
                        CommonConstants.HORIZONTAL_LINE+
                securityIndex.getFundNo(),
                TradeRuleConstant.VAL_PARAM_DIC_FP001,"methodCode");
        //计算持仓成本
        BigDecimal positionCost = positionCostFactory.getInstance(costAccount).cal();
        //3.获取投资标志
        String investFlag= securityIndex.getInvestFlag();
        //计算持仓市值
        BigDecimal positionMarketValue = positionMarketValueFactory.getInstance(investFlag).cal();

        indexVO.setFairPrice(fairPrice);
        indexVO.setPositionCost(positionCost);
        indexVO.setPositionMarketValue(positionMarketValue);
        //持仓成本/持仓数量
        indexVO.setCostPrice(positionCost.divide(indexVO.getPositionAmount()));
        //浮动盈亏=持仓市值-持仓成本
        indexVO.setFloatingPL(positionMarketValue.subtract(positionCost));

        securityIndex.setIndexVO(indexVO);
        return indexVO;
    }

    @Override
    public SecurityIndexVO calPositionIndex(SecurityIndex oldIndex) {
        SecurityIndexVO indexVO = new SecurityIndexVO();

        //计算公允价格
        BigDecimal fairPrice = oldIndex.getIndexVO().getFairPrice();
        //2.获取成本转结方式
        String costAccount= RedisServiceUtil.getRedisJsonFieldValue(RedisKeyPrefix.FUND_CONFIG+
                        CommonConstants.HORIZONTAL_LINE+
                        securityIndex.getFundNo(),
                TradeRuleConstant.VAL_PARAM_DIC_FP001,"methodCode");
        //计算持仓成本
        BigDecimal positionCost = positionCostFactory.getInstance(costAccount).cal();
        //3.获取投资标志
        String investFlag= securityIndex.getInvestFlag();
        //计算持仓市值
        BigDecimal positionMarketValue = positionMarketValueFactory.getInstance(investFlag).cal();
        indexVO.setFairPrice(fairPrice);
        indexVO.setPositionCost(positionCost);
        indexVO.setPositionMarketValue(positionMarketValue);
        //持仓成本/持仓数量
        indexVO.setCostPrice(positionCost.divide(indexVO.getPositionAmount()));
        //浮动盈亏=持仓市值-持仓成本
        indexVO.setFloatingPL(positionMarketValue.subtract(positionCost));
        securityIndex.setIndexVO(indexVO);
        return indexVO;
    }

}
