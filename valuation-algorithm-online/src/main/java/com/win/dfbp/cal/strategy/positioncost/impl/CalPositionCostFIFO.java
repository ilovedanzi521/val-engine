/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:35
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionCostFIFO.java
 * 文件描述: @Description: 成本结转方式= 先进先出时持仓成本
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.strategy.positioncost.impl;

import com.win.dfbp.cal.strategy.positioncost.ICalPositionCost;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityParam;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.positioncost.impl
 * 类名称：CalPositionCostFIFO
 * 类描述：成本结转方式= 先进先出时持仓成本
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:35
 */
@Service
public class CalPositionCostFIFO implements ICalPositionCost {
    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        return null;
    }

    @Override
    public BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam) {
        return null;
    }
}
