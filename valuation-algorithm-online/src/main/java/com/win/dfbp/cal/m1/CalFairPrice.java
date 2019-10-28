/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/11:36
 * 项目名称: dfbp-val-engine
 * 文件名称: CalFairPrice.java
 * 文件描述: @Description: 计算公允价
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.m1;

import com.win.dfas.common.util.SpringContextUtil;
import com.win.dfbp.cal.ISecurityCalculation;
import com.win.dfbp.cal.strategy.fairprice.FairPriceFactory;
import com.win.dfbp.cal.strategy.positionmarketvalue.PositionMarketValueFactory;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.cal.m1
 * 类名称：CalFairPrice
 * 类描述：计算公允价
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/11:36
 */
public class CalFairPrice implements ISecurityCalculation {
    private FairPriceFactory fairPriceFactory = SpringContextUtil.getBean(FairPriceFactory.class);

    private static final String clz = CalFairPrice.class.getName();
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        if(clz.equals(algorithm)){
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        String valCriteria = securityParam.getValCriteria();
        //计算公允价格
        BigDecimal fairPrice = fairPriceFactory.getInstance(valCriteria).calFairPrice(securityParam);
        securityParam.setFairPrice(fairPrice);
        return fairPrice;
    }
    /**
     * @Title: cal
     * @Description 直接获取
     * @param oldIndex
     * @param securityParam
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/28/17:05
     */
    @Override
    public BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam) {
        BigDecimal fairPrice = oldIndex.getIndexVO().getFairPrice();
        securityParam.setFairPrice(fairPrice);
        return fairPrice;

    }
}
