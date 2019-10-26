/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-21/10:18
 * 项目名称: dfbp-val-engine
 * 文件名称: ValPosition.java
 * 文件描述: @Description: 持仓信息
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.entity;

import com.win.dfas.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：ValPosition
 * 类描述：持仓信息
 * 创建人：@author zoujian
 * 创建时间：2019-10-21/10:18
 */
@ApiModel(value = "持仓信息实体类")
@Data
public class ValPosition extends BaseEntity {
    private String fundNo;
    private String fundCharacter;
    private String portfNo;
    private String securityCode;
    private String marketCode;
    private String platformCode;
    private String securityCharacter;
    private String investFlag;
    private String tradeDirection;
    /**
     * 持仓金额
     */
    private BigDecimal cashSettleBalance;
    /**
     * 持仓成本
     */
    private BigDecimal positionCost;
    /**
     * 持仓市值
     */
    private BigDecimal positionMarketValue;
    /**
     * 公允价
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
     * 持仓数量
     */
    private BigDecimal positionAmount;
    /**
     * 原始价
     */
    private BigDecimal originalPrice;
}
