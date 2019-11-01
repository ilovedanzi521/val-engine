/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationItem.java
 * 文件描述: @Description: TODO
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
 * 类名称：ValCalculationItem
 * 类描述：估值计算项类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:26:49
 *
 */
@ApiModel(value="ValCalculationIte对象", description="估值计算项表")
@Data
public class ValCalculationItem  extends  BaseEntity {


	private static final long serialVersionUID = 1L;
	/**
     * 计算项
     */
    @ApiModelProperty(value = "计算项")
    @NotNull(message = "计算项")
	private String calItem;
    /**
     * 计算公式
     */
    @ApiModelProperty(value = "计算公式")
	private String calFormula;
}
