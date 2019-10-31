/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/11:01
 * 项目名称: dfbp-val-engine
 * 文件名称: ICalPositionMarketValue.java
 * 文件描述: @Description: 按照投资标志选择
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.cal.strategy.positionmarketvalue;


import com.win.dfbp.val.common.entity.SecurityParam;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.investflag
 * 类名称：ICalPositionMarketValue
 * 类描述：按照投资标志计算持仓市值
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/11:01
 */
public interface ICalPositionMarketValue {
    public BigDecimal cal(SecurityParam securityParam);
}
