/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValClass.java
 * 文件描述: @Description: 估值分类
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
 * 类名称：ValClass
 * 类描述：估值分类类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:26:49
 *
 */
@ApiModel(value="ValClass对象", description="估值分类表")
@Data
public class ValClass  extends  BaseEntity {


	private static final long serialVersionUID = 1L;
	/**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码")
    @NotNull(message = "分类编码")
	private String classCode;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
	private String className;
}
