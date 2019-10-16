/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/14:20
 * 项目名称: dfbp-val-engine
 * 文件名称: PositionCostFactory.java
 * 文件描述: @Description: 持仓成本工厂类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.positioncost;

import com.win.dfbp.constant.TradeRuleConstant;
import com.win.dfbp.strategy.fairprice.ICalFairPrice;
import com.win.dfbp.strategy.fairprice.impl.*;
import com.win.dfbp.strategy.positioncost.impl.CalPositionCost1;
import com.win.dfbp.strategy.positioncost.impl.CalPositionCost2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.strategy.positioncost
 * 类名称：PositionCostFactory
 * 类描述：持仓成本工厂类
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/14:20
 */
@Component
@Slf4j
public class PositionCostFactory {
    //成本结转方式= 加权平均 持仓成本
    @Autowired
    private CalPositionCost1 calPositionCost1;
    //成本结转方式= 先进先出时 持仓成本
    @Autowired
    private CalPositionCost2 calPositionCost2;


    public ICalPositionCost getInstance(String type){
        switch (type){
            case TradeRuleConstant.VAL_PARAM_C001:
                return calPositionCost1;
            case TradeRuleConstant.VAL_PARAM_C002:
                return calPositionCost2;
            default:
                log.error("成本结转方式错误");
        }
        return null;
    }
}
