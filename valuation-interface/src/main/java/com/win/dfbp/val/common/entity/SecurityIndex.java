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

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndex
 * 类描述：证券指标
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:42
 */
@Data
public class SecurityIndex extends BaseKey {
    /**
     * 指标
     */
    private SecurityIndexVO indexVO;


    public SecurityIndexCash parseSecurityIndexCash(){
        SecurityIndexCash cash = new SecurityIndexCash();
        cash.setPro(this);
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
