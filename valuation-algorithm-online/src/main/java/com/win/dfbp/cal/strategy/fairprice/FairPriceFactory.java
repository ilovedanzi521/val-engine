/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/14:06
 * 项目名称: dfbp-val-engine
 * 文件名称: FairPriceFactory.java
 * 文件描述: @Description: 公允价格工厂类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.strategy.fairprice;

import com.win.dfbp.cal.strategy.fairprice.impl.*;
import com.win.dfbp.constant.TradeRuleConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.strategy.fairprice
 * 类名称：FairPriceFactory
 * 类描述：公允价格工厂类
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/14:06
 */
@Component
@Slf4j
public class FairPriceFactory {
    //净价 公允价计算
    @Autowired
    private CalFairPriceOnNetPrice calFairPriceOnNetPrice;
    //净价加税百元利息 公允价计算
    @Autowired
    private CalFairPriceOnNetPriceAndRates calFairPriceOnNetPriceAndRates;
    //全价 公允价计算
    @Autowired
    private CalFairPriceOnFullPrice calFairPriceOnFullPrice;
    //全价减税前百元利息 公允价计算
    @Autowired
    private CalFairPriceOnFullPriceSubBefRates calFairPriceOnFullPriceSubBefRates;
    //全价减税后百元利息 公允价计算
    @Autowired
    private CalFairPriceOnFullPriceSubAfterRates calFairPriceOnFullPriceSubAfterRates;
    //成本 公允价计算
    @Autowired
    private CalFairPriceOnCostPrice calFairPriceOnCostPrice;

    public AbsCalFairPrice getInstance(String type){
        switch (type){
            case TradeRuleConstant.VAL_CRITERIA_P001:
                return calFairPriceOnNetPrice;
            case TradeRuleConstant.VAL_CRITERIA_P002:
                return calFairPriceOnNetPriceAndRates;
            case TradeRuleConstant.VAL_CRITERIA_P003:
                return calFairPriceOnFullPrice;
            case TradeRuleConstant.VAL_CRITERIA_P004:
                return calFairPriceOnFullPriceSubBefRates;
            case TradeRuleConstant.VAL_CRITERIA_P005:
                return calFairPriceOnFullPriceSubAfterRates;
            case TradeRuleConstant.VAL_CRITERIA_P006:
                return calFairPriceOnCostPrice;
            default:
               log.error("估值标准参数方法错误");
        }
        return null;
    }
}
