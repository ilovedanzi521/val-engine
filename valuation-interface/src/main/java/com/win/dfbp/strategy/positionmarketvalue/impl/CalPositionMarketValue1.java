/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:24
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionMarketValue1.java
 * 文件描述: @Description: 计算持仓市值
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.positionmarketvalue.impl;

import com.win.dfbp.strategy.positionmarketvalue.ICalPositionMarketValue;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.positionmarketvalue.impl
 * 类名称：CalPositionMarketValue1
 * 类描述：计算持仓市值 投资标志=交易性/可供出售
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:24
 */
@Service
public class CalPositionMarketValue1 implements ICalPositionMarketValue {
    @Override
    public BigDecimal cal() {
        return null;
    }
}
