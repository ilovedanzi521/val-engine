/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValFundStatus.java
 * 文件描述: @Description: 估值产品状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.entity;


import com.win.dfas.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 包名称： com.win.dfbp.val.manage.entity
 * 类名称：ValFundStatus
 * 类描述：估值产品状态类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:26:49
 *
 */
@ApiModel(value="ValFundStatus对象", description="估值产品状态表")
@Data
public class ValFundStatus  extends  BaseEntity {


	private static final long serialVersionUID = 1L;
	/**
     * 产品状态编码
     */
    @ApiModelProperty(value = "产品状态编码")
    @NotNull(message = "产品状态编码")
	private String fundStatusCode;
    /**
     * 产品状态名称
     */
    @ApiModelProperty(value = "产品状态名称")
	private String fundStatusName;
}
