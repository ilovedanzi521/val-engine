/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValItem.java
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
 * 类名称：ValItem
 * 类描述：计算因子类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:26:49
 *
 */
@ApiModel(value="ValItem对象", description="计算因子表")
@Data
public class ValItem  extends  BaseEntity {


	private static final long serialVersionUID = 1L;
	/**
     * 计算编码
     */
    @ApiModelProperty(value = "计算编码")
    @NotNull(message = "计算编码")
	private String itemCode;
    /**
     * 计算名称
     */
    @ApiModelProperty(value = "计算名称")
	private String itemName;
    /**
     * 计算层级
     */
    @ApiModelProperty(value = "计算层级")
   	private Integer itemLevel;
}
