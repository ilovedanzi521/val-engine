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

package com.win.dfbp.cal.strategy.positionmarketvalue.impl;

import cn.hutool.core.util.ObjectUtil;
import com.win.dfbp.cal.strategy.positionmarketvalue.ICalPositionMarketValue;
import com.win.dfbp.entity.SecurityParam;
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
    public BigDecimal cal(SecurityParam securityParam) {
        //持仓市值 = round（iff（公允价<>” ”,持仓数量  * 公允价 , 持仓成本）  ，2）
        if(ObjectUtil.isEmpty(securityParam.getFairPrice())){
            return securityParam.getPositionCost();
        }else{
            return securityParam.getPositionAmount().multiply(securityParam.getFairPrice());
        }
    }
}
