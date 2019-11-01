/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:04:53
 * 项目名称：  valuation-manage
 * 文件名称: ValClassMethodRepVO.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.vo.respone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.win.dfbp.val.manage.vo.respone
 * 类名称：ValClassMethodRepVO
 * 类描述：估值分类方法行转列
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:04:53
 *
 */
@Data
@ApiModel(value = "ValClassMethodRepVO对象", description = "估值分类方法行转列VO")
public class ValClassMethodRepVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 公允价对应的method_code
     */
    @ApiModelProperty(value = "公允价")
	private String fairPrice;
    /**
     * 持仓成本对应的method_code
     */
    @ApiModelProperty(value = "持仓成本")
	private String positionCost;
    /**
     * 持仓市值对应的method_code
     */
    @ApiModelProperty(value = "持仓市值")
	private String positionMarket;
    /**
     * 成本价对应的method_code
     */
    @ApiModelProperty(value = "成本价")
	private String costPrice;
    /**
     * 浮动盈亏对应的method_code
     */
    @ApiModelProperty(value = "浮动盈亏")
   	private String floatingProfitLoss;
    /**
     * 公允价对应的方法名称
     */
    @ApiModelProperty(value = "公允价方法名称")
	private String fairPriceName;
    /**
     * 持仓成本对应的方法名称
     */
    @ApiModelProperty(value = "持仓成本方法名称")
	private String positionCostName;
    /**
     * 持仓市值对应的方法名称
     */
    @ApiModelProperty(value = "持仓市值方法名称")
	private String positionMarketName;
    /**
     * 成本价对应的方法名称
     */
    @ApiModelProperty(value = "成本价方法名称")
	private String costPriceName;
    /**
     * 浮动盈亏对应的方法名称
     */
    @ApiModelProperty(value = "浮动盈亏方法名称")
   	private String floatingProfitLossName;

}
