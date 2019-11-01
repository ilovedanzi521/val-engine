/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:04:53
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodConfigureRepVO.java
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
import java.util.List;

/**
 * 包名称： com.win.dfbp.val.manage.vo.respone
 * 类名称：ValMethodConfigureRepVO
 * 类描述：估值分类方法行转列
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:04:53
 *
 */
@Data
@ApiModel(value = "ValMethodConfigureRepVO对象", description = "估值分类方法listVO")
public class ValMethodConfigureRepVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 公允价方法list
     */
    @ApiModelProperty(value = "公允价")
	private List<ValClassMethodConfigureReqVO> fairPrices;
    /**
     * 持仓成本方法list
     */
    @ApiModelProperty(value = "持仓成本")
    private List<ValClassMethodConfigureReqVO> positionCosts;
    /**
     * 持仓市值方法list
     */
    @ApiModelProperty(value = "持仓市值")
    private List<ValClassMethodConfigureReqVO> positionMarkets;
    /**
     * 成本价方法list
     */
    @ApiModelProperty(value = "成本价")
    private List<ValClassMethodConfigureReqVO> costPrices;
    /**
     * 浮动盈亏方法list
     */
    @ApiModelProperty(value = "浮动盈亏")
    private List<ValClassMethodConfigureReqVO> floatingProfitLoss;

}
