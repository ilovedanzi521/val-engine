/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/14:28
 * 项目名称: dfbp-val-engine
 * 文件名称: PositionMarketValueFactory.java
 * 文件描述: @Description: 持仓市值工厂类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.strategy.positionmarketvalue;

import com.win.dfbp.cal.strategy.positionmarketvalue.impl.CalPositionMarketValue1;
import com.win.dfbp.cal.strategy.positionmarketvalue.impl.CalPositionMarketValue2;
import com.win.dfbp.constant.TradeRuleConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.strategy.positionmarketvalue
 * 类名称：PositionMarketValueFactory
 * 类描述：持仓市值工厂类
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/14:28
 */
@Component
@Slf4j
public class PositionMarketValueFactory {
    /**
     *  投资标志=交易性/可供出售
     */
    @Autowired
    private CalPositionMarketValue1 calPositionMarketValue1;
    /**
     *  投资标志=持有至到期/贷款
     */
    @Autowired
    private CalPositionMarketValue2 calPositionMarketValue2;


    public ICalPositionMarketValue getInstance(String type){
        switch (type){
            case TradeRuleConstant.INVEST_FLAG_J:
            case TradeRuleConstant.INVEST_FLAG_F:
                return calPositionMarketValue1;
            case TradeRuleConstant.INVEST_FLAG_C:
            case TradeRuleConstant.INVEST_FLAG_Y:
                return calPositionMarketValue2;
            default:
                log.error("投资标志错误");
        }
        return null;
    }
}
