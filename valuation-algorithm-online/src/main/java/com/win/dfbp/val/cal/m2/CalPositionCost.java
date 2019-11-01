/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/11:37
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionCost.java
 * 文件描述: @Description: 计算持仓成本
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.cal.m2;

import com.win.dfbp.val.cal.ISecurityCalculation;
import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityParam;


import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.cal.m2
 * 类名称：CalPositionCost
 * 类描述：计算持仓成本
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/11:37
 */
public class CalPositionCost implements ISecurityCalculation {
    private static final String CLZ = CalPositionCost.class.getName();
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        if(CLZ.equals(algorithm)){
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        return BigDecimal.ONE;
    }

    @Override
    public BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam) {
        return BigDecimal.ONE;
    }
}
