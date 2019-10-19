/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:24
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexState.java
 * 文件描述: @Description: 指标状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.state;

import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexState
 * 类描述：指标状态
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:24
 */
@Data
public class SecurityIndexState implements Serializable {
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
     * 指标
     */
    private SecurityIndexVO indexVO;

    public SecurityIndexState clone(SecurityIndex securityIndex){
        this.setFundCharacter(securityIndex.getFundCharacter());
        this.setFundNo(securityIndex.getFundNo());
        this.setInvestFlag(securityIndex.getInvestFlag());
        this.setMarketCode(securityIndex.getMarketCode());
        this.setPlatformCode(securityIndex.getPlatformCode());
        this.setPortfNo(securityIndex.getPortfNo());
        this.setSecurityCharacter(securityIndex.getSecurityCharacter());
        this.setSecurityCode(securityIndex.getSecurityCode());
        this.setCashSettleBalance(securityIndex.getCashSettleBalance());
        this.setStockSettleAmount(securityIndex.getStockSettleAmount());
        SecurityIndexVO indexVO = new SecurityIndexVO();
        indexVO.setPositionAmount(securityIndex.getIndexVO().getPositionAmount());
        indexVO.setCostPrice(securityIndex.getIndexVO().getCostPrice());
        indexVO.setFairPrice(securityIndex.getIndexVO().getFairPrice());
        indexVO.setFloatingPL(securityIndex.getIndexVO().getFloatingPL());
        indexVO.setPositionCost(securityIndex.getIndexVO().getPositionCost());
        indexVO.setPositionMarketValue(securityIndex.getIndexVO().getPositionMarketValue());
        indexVO.setInterestRateOfHundred(securityIndex.getIndexVO().getInterestRateOfHundred());
        this.setIndexVO(indexVO);
        return this;
    }

    public SecurityIndex parse(){
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
        indexVO.setPositionAmount(this.getIndexVO().getPositionAmount());
        indexVO.setCostPrice(this.getIndexVO().getCostPrice());
        indexVO.setFairPrice(this.getIndexVO().getFairPrice());
        indexVO.setFloatingPL(this.getIndexVO().getFloatingPL());
        indexVO.setPositionCost(this.getIndexVO().getPositionCost());
        indexVO.setPositionMarketValue(this.getIndexVO().getPositionMarketValue());
        indexVO.setInterestRateOfHundred(this.getIndexVO().getInterestRateOfHundred());
        index.setIndexVO(indexVO);
        return index;
    }
}
