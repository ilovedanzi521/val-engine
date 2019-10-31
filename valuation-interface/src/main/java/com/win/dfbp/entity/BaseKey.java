/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/28/14:00
 * 项目名称: dfbp-val-engine
 * 文件名称: BaseKey.java
 * 文件描述: @Description: 基础主键信息
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：BaseKey
 * 类描述：基础主键信息
 * 创建人：@author wanglei
 * 创建时间：2019/10/28/14:00
 */
@Data
public class BaseKey {
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
     * 金额';
     */
    private BigDecimal cashSettleBalance;
    /**
     * 交易数量
     */
    private BigDecimal stockSettleAmount;
    /**
     * 交易方向 多空标志
     */
    private String tradeDirection;
    /**
     * 交易所含利息
     */
    private BigDecimal tradeRates;

    public void setPro(BaseKey baseKey){
        this.setFundCharacter(baseKey.getFundCharacter());
        this.setFundNo(baseKey.getFundNo());
        this.setInvestFlag(baseKey.getInvestFlag());
        this.setMarketCode(baseKey.getMarketCode());
        this.setPlatformCode(baseKey.getPlatformCode());
        this.setPortfNo(baseKey.getPortfNo());
        this.setSecurityCharacter(baseKey.getSecurityCharacter());
        this.setSecurityCode(baseKey.getSecurityCode());
        this.setCashSettleBalance(baseKey.getCashSettleBalance());
        this.setStockSettleAmount(baseKey.getStockSettleAmount());
        this.setTradeDirection(baseKey.getTradeDirection());
        this.setTradeRates(baseKey.getTradeRates());
    }

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
}
