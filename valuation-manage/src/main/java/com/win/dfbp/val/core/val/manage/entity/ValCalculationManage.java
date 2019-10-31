/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationManage.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.core.val.manage.entity;




import com.win.dfas.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 包名称： com.win.dfbp.val.manage.entity
 * 类名称：ValCalculationManage
 * 类描述：估值计算方法管理类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:26:49
 *
 */
@ApiModel(value="ValCalculationManage对象", description="估值计算方法管理表")
@Data
public class ValCalculationManage  extends  BaseEntity {


	private static final long serialVersionUID = 1L;
	/**
     * 估值分类
     */
    @ApiModelProperty(value = "估值分类")
	private String valClass;
    /**
     * 估值方法
     */
    @ApiModelProperty(value = "估值方法")
	private String valMethod;
    /**
     * 计算公式
     */
    @ApiModelProperty(value = "计算公式")
	private String calFormula;
    /**
     * 计算类型 0-计算公式、1-计算模型
     */
    @ApiModelProperty(value = "计算类型(0-计算公式、1-计算模型)")
	private Integer calType;
    /**
     * 计算模型路径
     */
    @ApiModelProperty(value = "计算模型路径")
	private String calModelClasspath;

}
