/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:20
 * 项目名称: dfbp-val-engine
 * 文件名称: CalFairPriceOnFullPrice.java
 * 文件描述: @Description: 估值参数为全价时，公允价计算标准
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.strategy.fairprice.impl;

import com.win.dfbp.cal.strategy.fairprice.AbsCalFairPrice;
import com.win.dfbp.entity.SecurityParam;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 包名称：com.win.dfbp.strategy.fairprice.impl
 * 类名称：CalFairPriceOnFullPrice
 * 类描述：估值参数为全价时，公允价计算标准
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:20
 */
@Service
public class CalFairPriceOnFullPrice extends AbsCalFairPrice {
    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        //公允价= round（公共行情[估值全价]，N）
        return securityParam.getFullPrice().setScale(securityParam.getDecimalAccuracy(), RoundingMode.HALF_EVEN);
    }
}
