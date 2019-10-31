/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/11:24
 * 项目名称: dfbp-val-engine
 * 文件名称: AbstractCalFairPrice.java
 * 文件描述: @Description: 计算公允价
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.strategy.fairprice;

import com.win.dfbp.entity.SecurityParam;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.fairprice
 * 类名称：AbstractCalFairPrice
 * 类描述：计算公允价
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/11:24
 */
public abstract class AbstractCalFairPrice {
    /**
     * @Title: cal
     * @Description 计算公允价
     * @param securityParam
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/18/11:50
     */
    public abstract BigDecimal cal(SecurityParam securityParam);
    /**
     * @Title: calFairPrice
     * @Description 计算公允价
     * @param securityParam
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/31/13:56
     */
    public BigDecimal calFairPrice(SecurityParam securityParam){
        BigDecimal fairPrice = cal(securityParam);
        return fairPrice;
    }
}
