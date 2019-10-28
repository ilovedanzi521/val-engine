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

package com.win.dfbp.cal.strategy.positioncost;

import com.win.dfbp.cal.strategy.positioncost.impl.CalPositionCostFIFO;
import com.win.dfbp.cal.strategy.positioncost.impl.CalPositionCostWeightedAverag;
import com.win.dfbp.constant.TradeRuleConstant;
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
    private CalPositionCostWeightedAverag calPositionCostWeightedAverag;
    //成本结转方式= 先进先出时 持仓成本
    @Autowired
    private CalPositionCostFIFO calPositionCostFIFO;


    public ICalPositionCost getInstance(String type){
        switch (type){
            case TradeRuleConstant.VAL_PARAM_C001:
                return calPositionCostWeightedAverag;
            case TradeRuleConstant.VAL_PARAM_C002:
                return calPositionCostFIFO;
            default:
                log.error("成本结转方式错误");
        }
        return null;
    }
}
