/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:21
 * 项目名称: dfbp-val-engine
 * 文件名称: CalFairPrice4.java
 * 文件描述: @Description:
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
 * 类名称：CalFairPrice4
 * 类描述：估值参数为全价减税前百元利息时，公允价计算标准
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:21
 */
@Service
public class CalFairPrice4 extends AbsCalFairPrice {
    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        //公允价= round（公共行情[估值全价] + 税前百元利息，N）；
        BigDecimal endPrice = securityParam.getFullPrice().add(securityParam.getPretaxInterest());
        return endPrice.setScale(securityParam.getDecimalAccuracy(), RoundingMode.HALF_EVEN);
    }
}
