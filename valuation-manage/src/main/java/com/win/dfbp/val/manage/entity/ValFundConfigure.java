/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodConfigure.java
 * 文件描述: @Description: 估值方法
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
 * 类名称：ValMethodConfigure
 * 类描述：估值分类对应的方法配置类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:26:49
 *
 */
@ApiModel(value="ValMethodConfigure对象", description="估值分类对应的方法配置表")
@Data
public class ValFundConfigure  extends  BaseEntity {


	private static final long serialVersionUID = 1L;
	/**
     * 产品编码
     */
    @ApiModelProperty(value = "产品编码")
    @NotNull(message = "产品编码")
	private String fundNo;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
	private String fundName;
    /**
     * 产品状态编码
     */
    @ApiModelProperty(value = "产品状态编码")
	private String fundStatusCode;
    /**
     * 产品状态编码
     */
    @ApiModelProperty(value = "产品性质编码")
	private String fundCharacterCode;
}
