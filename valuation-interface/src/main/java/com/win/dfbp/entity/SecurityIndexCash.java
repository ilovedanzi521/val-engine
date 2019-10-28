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
public class SecurityIndexCash extends SecurityIndexVO{
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

    public SecurityIndex parseSecurityIndex(){
        SecurityIndex index = new SecurityIndex();
        index.setFundCharacter(this.getFundCharacter());
        index.setFundNo(this.getFundNo());
        index.setInvestFlag(this.getInvestFlag());
        index.setMarketCode(this.getMarketCode());
        index.setPlatformCode(this.getPlatformCode());
        index.setPortfNo(this.getPortfNo());
        index.setSecurityCharacter(this.getSecurityCharacter());
        index.setSecurityCode(this.getSecurityCode());
        index.setCashSettleBalance(this.getCashSettleBalance());
        index.setStockSettleAmount(this.getStockSettleAmount());
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
