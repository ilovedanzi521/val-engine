/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/11:37
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionMarketValue.java
 * 文件描述: @Description: 计算持仓市值
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.cal.m1;

import com.win.dfas.common.util.SpringContextUtil;
import com.win.dfbp.val.cal.ISecurityCalculation;
import com.win.dfbp.val.cal.strategy.positionmarketvalue.PositionMarketValueFactory;
import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityParam;


import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.cal.m1
 * 类名称：CalPositionMarketValue
 * 类描述：计算持仓市值
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/11:37
 */
public class CalPositionMarketValue implements ISecurityCalculation {
    private PositionMarketValueFactory positionMarketValueFactory = SpringContextUtil.getBean(PositionMarketValueFactory.class);
    private static final String CLZ = CalPositionMarketValue.class.getName();
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        if(CLZ.equals(algorithm)){
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        //投资标志
        String investFlag= securityParam.getInvestFlag();
        //计算持仓市值
        BigDecimal positionMarketValue = positionMarketValueFactory.getInstance(investFlag).cal(securityParam);
        securityParam.setPositionMarketValue(positionMarketValue);
        return positionMarketValue;
    }

    @Override

    public BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam) {
        return cal(securityParam);
    }
}
