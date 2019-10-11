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

package com.win.dfbp.engine.flink.state;

import lombok.Data;

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
     * 指标
     */
    private SecurityIndexVO indexVO;

    @Override
    public SecurityIndexState clone(){
        SecurityIndexState indexState = new SecurityIndexState();
        indexState.setFundCharacter(this.fundCharacter);
        indexState.setFundNo(this.fundNo);
        indexState.setInvestFlag(this.investFlag);
        indexState.setMarketCode(this.marketCode);
        indexState.setPlatformCode(this.platformCode);
        indexState.setPortfNo(this.portfNo);
        indexState.setSecurityCharacter(this.securityCharacter);
        indexState.setSecurityCode(this.securityCode);
        SecurityIndexVO indexVO = new SecurityIndexVO();
        indexVO.setCostPrice(this.getIndexVO().getCostPrice());
        indexVO.setFairPrice(this.getIndexVO().getFairPrice());
        indexVO.setFloatingPL(this.getIndexVO().getFloatingPL());
        indexVO.setPositionCost(this.getIndexVO().getPositionCost());
        indexVO.setPositionMarketValue(this.getIndexVO().getPositionMarketValue());
        indexVO.setInterestRateOfHundred(this.getIndexVO().getInterestRateOfHundred());
        indexState.setIndexVO(indexVO);
        return indexState;
    }
}
