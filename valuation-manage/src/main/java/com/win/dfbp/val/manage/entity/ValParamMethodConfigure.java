/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:26:49
 * 项目名称：  valuation-manage
 * 文件名称: ValParamMethodConfigure.java
 * 文件描述: @Description: 估值参数方法配置
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
 * 类名称：ValParamMethodConfigure 
 * 类描述：估值参数方法配置类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:26:49
 *     
 */
@ApiModel(value="ValParamConfigure对象", description="估值参数方法配置表")
@Data
public class ValParamMethodConfigure  extends  BaseEntity {
	
	
	private static final long serialVersionUID = 1L;
    /**
     * 参数编码
     */
    @ApiModelProperty(value = "参数编码")
	private String paramCode;
    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称")
	private String paramName;
    /**
     * 参数方法编码
     */
    @ApiModelProperty(value = "参数方法编码")
	private String methodCode;
    
    /**
     * 参数方法名称
     */
    @ApiModelProperty(value = "参数方法名称")
	private String methodName;
}