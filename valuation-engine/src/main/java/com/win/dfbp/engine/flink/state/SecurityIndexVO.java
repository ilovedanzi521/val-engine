/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:24
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexVO.java
 * 文件描述: @Description: 指标
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.state;

import lombok.Data;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexVO
 * 类描述：指标
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:24
 */
@Data
public class SecurityIndexVO {
    /**
     * 持仓成本
     */
    private String positionCost;
    /**
     * 持仓市值
     */
    private String positionMarketValue;
    /**
     * 百元利率
     */
    private String interestRateOfHundred;
    /**
     * 公允价格
     */
    private String fairPrice;
    /**
     * 成本价
     */
    private String costPrice;
    /**
     * 浮动盈亏
     */
    private String floatingPL;
}
