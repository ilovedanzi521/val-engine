/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/11:24
 * 项目名称: dfbp-val-engine
 * 文件名称: ICalFairPrice.java
 * 文件描述: @Description: 计算公允价
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.fairprice;

import com.win.dfbp.entity.SecurityIndexVO;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.fairprice
 * 类名称：ICalFairPrice
 * 类描述：计算公允价
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/11:24
 */
public interface ICalFairPrice {
    public BigDecimal cal();
}
