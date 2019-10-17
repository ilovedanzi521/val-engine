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

import java.util.List;

import javax.validation.constraints.NotNull;

import com.win.dfas.common.vo.BaseRepVO;
import com.win.dfbp.val.manage.entity.ValMethodConfigure;
import com.win.dfbp.val.manage.entity.ValParamConfigure;

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
public class ValFundConfigureRepVO extends BaseRepVO {
	
	private static final long serialVersionUID = 1L;
	/**
     * 产品编码
     */
    @ApiModelProperty(value = "产品编码")
    @NotNull(message = "产品编码")
	private String fundCode;
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
    /**
     * 关联方法配置
     */
    @ApiModelProperty(value = "关联方法配置")
    private List<ValMethodConfigure> methods;
    /**
     * 关联参数配置
     */
    @ApiModelProperty(value = "关联参数配置")
    private List<ValParamConfigure> params;
    
}
