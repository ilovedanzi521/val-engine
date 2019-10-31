/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:42
 * 项目名称: TestFlink
 * 文件名称: SecurityIndex.java
 * 文件描述: @Description: 证券指标
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.common.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndex
 * 类描述：证券指标 为了sql的缓存和存放的bean一致
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:42
 */
@Data
public class SecurityIndexCash extends BaseKey {
    /**
     * 持仓数量
     */
    private BigDecimal positionAmount;
    /**
     * 持仓成本
     */
    private BigDecimal positionCost;
    /**
     * 持仓市值
     */
    private BigDecimal positionMarketValue;
    /**
     * 百元利率
     */
    private BigDecimal interestRateOfHundred;
    /**
     * 公允价格
     */
    private BigDecimal fairPrice;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 浮动盈亏
     */
    private BigDecimal floatingPL;
    /**
     * 原始价
     */
    private BigDecimal originalPrice;


    public SecurityIndex parseSecurityIndex(){
        SecurityIndex index = new SecurityIndex();
        index.setPro(this);
        SecurityIndexVO indexVO = new SecurityIndexVO();
        indexVO.setPositionAmount(this.getPositionAmount());
        indexVO.setCostPrice(this.getCostPrice());
        indexVO.setFairPrice(this.getFairPrice());
        indexVO.setFloatingPL(this.getFloatingPL());
        indexVO.setPositionCost(this.getPositionCost());
        indexVO.setPositionMarketValue(this.getPositionMarketValue());
        indexVO.setInterestRateOfHundred(this.getInterestRateOfHundred());
        index.setIndexVO(indexVO);
        return index;
    }
}
