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

package com.win.dfbp.strategy.fairprice.impl;

import com.win.dfbp.strategy.fairprice.ICalFairPrice;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.fairprice.impl
 * 类名称：CalFairPrice4
 * 类描述：估值参数为全价减税前百元利息时，公允价计算标准
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:21
 */
@Service
public class CalFairPrice4 implements ICalFairPrice {
    @Override
    public BigDecimal cal() {
        return null;
    }
}
