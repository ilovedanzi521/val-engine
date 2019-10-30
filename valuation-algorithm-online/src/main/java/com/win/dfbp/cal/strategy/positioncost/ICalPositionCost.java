/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:34
 * 项目名称: dfbp-val-engine
 * 文件名称: ICalPositionCost.java
 * 文件描述: @Description: 计算持仓成本
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.strategy.positioncost;

import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityParam;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.positioncost
 * 类名称：ICalPositionCost
 * 类描述：计算持仓成本
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:34
 */
public interface ICalPositionCost {
    public BigDecimal cal(SecurityParam securityParam);

    BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam);
}
