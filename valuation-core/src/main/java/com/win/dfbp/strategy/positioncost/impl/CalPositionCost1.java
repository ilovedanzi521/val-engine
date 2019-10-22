/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:35
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionCost1.java
 * 文件描述: @Description: 成本结转方式= 加权平均时持仓成本
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.positioncost.impl;

import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.strategy.positioncost.ICalPositionCost;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.positioncost.impl
 * 类名称：CalPositionCost1
 * 类描述：成本结转方式= 加权平均时持仓成本
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:35
 */
@Service
public class CalPositionCost1 implements ICalPositionCost {

    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        return securityParam.getPositionCost();
    }
}