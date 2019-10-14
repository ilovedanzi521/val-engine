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
     * 指标
     */
    private SecurityIndexVO indexVO;

    public SecurityIndexState clone(SecurityIndex securityIndex){
        SecurityIndexState indexState = new SecurityIndexState();
        indexState.setFundCharacter(securityIndex.getFundCharacter());
        indexState.setFundNo(securityIndex.getFundNo());
        indexState.setInvestFlag(securityIndex.getInvestFlag());
        indexState.setMarketCode(securityIndex.getMarketCode());
        indexState.setPlatformCode(securityIndex.getPlatformCode());
        indexState.setPortfNo(securityIndex.getPortfNo());
        indexState.setSecurityCharacter(securityIndex.getSecurityCharacter());
        indexState.setSecurityCode(securityIndex.getSecurityCode());
        SecurityIndexVO indexVO = new SecurityIndexVO();
        indexVO.setCostPrice(securityIndex.getIndexVO().getCostPrice());
        indexVO.setFairPrice(securityIndex.getIndexVO().getFairPrice());
        indexVO.setFloatingPL(securityIndex.getIndexVO().getFloatingPL());
        indexVO.setPositionCost(securityIndex.getIndexVO().getPositionCost());
        indexVO.setPositionMarketValue(securityIndex.getIndexVO().getPositionMarketValue());
        indexVO.setInterestRateOfHundred(securityIndex.getIndexVO().getInterestRateOfHundred());
        indexState.setIndexVO(indexVO);
        return indexState;
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
        SecurityIndexVO indexVO = new SecurityIndexVO();
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
