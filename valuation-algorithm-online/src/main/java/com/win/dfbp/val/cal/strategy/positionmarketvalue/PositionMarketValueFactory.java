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

package com.win.dfbp.val.cal.strategy.positionmarketvalue;

import com.win.dfbp.val.cal.strategy.positionmarketvalue.impl.CalPositionMarketValueOnHold;
import com.win.dfbp.val.cal.strategy.positionmarketvalue.impl.CalPositionMarketValueOnTradable;
import com.win.dfbp.val.common.constant.TradeRuleConstant;
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
    private CalPositionMarketValueOnTradable calPositionMarketValueOnTradable;
    /**
     *  投资标志=持有至到期/贷款
     */
    @Autowired
    private CalPositionMarketValueOnHold calPositionMarketValueOnHold;


    public ICalPositionMarketValue getInstance(String type){
        switch (type){
            case TradeRuleConstant.INVEST_FLAG_J:
            case TradeRuleConstant.INVEST_FLAG_F:
                return calPositionMarketValueOnTradable;
            case TradeRuleConstant.INVEST_FLAG_C:
            case TradeRuleConstant.INVEST_FLAG_Y:
                return calPositionMarketValueOnHold;
            default:
                log.error("投资标志错误");
        }
        return null;
    }
}
