/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:04:53
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationManageRepVO.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.vo.respone;

import com.win.dfas.common.vo.BaseRepVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfbp.val.manage.vo.respone 
 * 类名称：ValCalculationManageRepVO 
 * 类描述：TODO
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:04:53
 *     
 */
@Data
@ApiModel(value = "ValCalculationManageRepVO对象", description = "估值计算方法管理VO")
public class ValCalculationManageRepVO extends BaseRepVO {
	
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
     * 估值方法名称
     */
    @ApiModelProperty(value = "估值方法名称")
	private String methodName;
    /**
     * 计算公式
     */
    @ApiModelProperty(value = "计算公式")
	private String calFormula;
    /**
     * 计算公式名称
     */
    @ApiModelProperty(value = "计算公式名称")
	private String calFormulaStr;
    /**
     * 计算类型 0-计算公式、1-计算模型
     */
    @ApiModelProperty(value = "计算类型(0-计算公式、1-计算模型)")
	private Integer calType;
    
}
