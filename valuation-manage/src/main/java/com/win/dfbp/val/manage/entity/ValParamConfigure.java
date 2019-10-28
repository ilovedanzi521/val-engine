/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValParamConfigure.java
 * 文件描述: @Description: 产品估值配置
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

/**   
 * 包名称： com.win.dfbp.val.manage.entity 
 * 类名称：ValParamConfigure 
 * 类描述：产品估值配置类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:26:49
 *     
 */
@ApiModel(value="ValParamConfigure对象", description="产品估值配置表")
@Data
public class ValParamConfigure  extends  BaseEntity {
	
	
	private static final long serialVersionUID = 1L;
	/**
     * 方法编码
     */
    @ApiModelProperty(value = "方法编码")
	private String methodCode;
    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数编码")
	private String paramCode;
    
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
	private Long fundConfigureId;

	public ValParamConfigure(String paramCode,String methodCode, Long fundConfigureId) {
		
		this.methodCode = methodCode;
		this.paramCode = paramCode;
		this.fundConfigureId = fundConfigureId;
	}

	public ValParamConfigure() {
	}
    
    
}
