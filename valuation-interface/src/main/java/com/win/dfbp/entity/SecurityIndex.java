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

package com.win.dfbp.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndex
 * 类描述：证券指标
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:42
 */
@Data
public class SecurityIndex {
    /**
     * 产品代码
     */
    private String fundNo;
    /**
     * 产品性质
     */
    private String fundCharacter;
    /**
     * 组合代码
     */
    private String portfNo;
    /**
     *  证券代码
     */
    private String securityCode;
    /**
     * 交易市场
     */
    private String marketCode;
    /**
     * 交易平台
     */
    private String platformCode;
    /**
     * 证券性质
     */
    private String securityCharacter;
    /**
     * 投资标志
     */
    private String investFlag;
    /**
     * 交易数量
     */
    private BigDecimal cashSettleBalance;
    /**
     * 交易金额
     */
    private BigDecimal stockSettleAmount;
    /**
     * 交易方向
     */
    private String tradeDirection;
    /**
     * 指标
     */
    private SecurityIndexVO indexVO;
    /**
     * @Title: key
     * @Description 返回SecurityIndex 主键key
     * @param
     * @return java.lang.String
     * @throws
     * @author wanglei
     * @Date 2019/10/22/10:18
     */
    public String key(){
        return this.getSecurityCode()+
                this.getMarketCode()+this.getSecurityCharacter()+getInvestFlag()+this.getFundNo()+this.getPortfNo();
    }

    public SecurityIndexCash parseSecurityIndexCash(){
        SecurityIndexCash cash = new SecurityIndexCash();
        cash.setFundCharacter(this.getFundCharacter());
        cash.setFundNo(this.getFundNo());
        cash.setInvestFlag(this.getInvestFlag());
        cash.setMarketCode(this.getMarketCode());
        cash.setPlatformCode(this.getPlatformCode());
        cash.setPortfNo(this.getPortfNo());
        cash.setSecurityCharacter(this.getSecurityCharacter());
        cash.setSecurityCode(this.getSecurityCode());
        cash.setCashSettleBalance(this.getCashSettleBalance());
        cash.setStockSettleAmount(this.getStockSettleAmount());
        cash.setPositionAmount(this.getIndexVO().getPositionAmount());
        cash.setCostPrice(this.getIndexVO().getCostPrice());
        cash.setFairPrice(this.getIndexVO().getFairPrice());
        cash.setFloatingPL(this.getIndexVO().getFloatingPL());
        cash.setPositionCost(this.getIndexVO().getPositionCost());
        cash.setPositionMarketValue(this.getIndexVO().getPositionMarketValue());
        cash.setInterestRateOfHundred(this.getIndexVO().getInterestRateOfHundred());
        return cash;
    }
}
