/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:24
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionMarketValueOnHold.java
 * 文件描述: @Description: 计算持仓市值
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.cal.strategy.positionmarketvalue.impl;

import com.win.dfbp.val.cal.strategy.positionmarketvalue.ICalPositionMarketValue;
import com.win.dfbp.val.common.entity.SecurityParam;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.positionmarketvalue.impl
 * 类名称：CalPositionMarketValueOnHold
 * 类描述：计算持仓市值 投资标志=持有至到期/贷款
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:24
 */
@Service
public class CalPositionMarketValueOnHold implements ICalPositionMarketValue {
    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        return securityParam.getPositionCost();
    }
}
