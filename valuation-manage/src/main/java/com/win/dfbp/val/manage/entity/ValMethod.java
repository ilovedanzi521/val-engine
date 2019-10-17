/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: Valmethod.java
 * 文件描述: @Description: 估值方法
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.entity;



import javax.validation.constraints.NotNull;

import com.win.dfas.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfbp.val.manage.entity 
 * 类名称：Valmethod 
 * 类描述：估值方法类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:26:49
 *     
 */
@ApiModel(value="ValMethod对象", description="估值方法表")
@Data
public class ValMethod  extends  BaseEntity {
	
	
	private static final long serialVersionUID = 1L;
	/**
     * 方法编码
     */
    @ApiModelProperty(value = "方法编码")
    @NotNull(message = "方法编码")
	private String methodCode;
    /**
     * 方法名称
     */
    @ApiModelProperty(value = "方法名称")
	private String methodName;
}
