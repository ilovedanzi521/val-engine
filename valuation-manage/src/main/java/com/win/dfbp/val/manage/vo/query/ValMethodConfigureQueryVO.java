/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:19:03
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodConfigureQueryVO.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.vo.query;


import com.win.dfas.common.vo.BaseQryReqVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfbp.val.manage.vo.query 
 * 类名称：ValMethodConfigureQueryVO 
 * 类描述：根据方法类型查询方法配置VO
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:19:03
 *     
 */
@Data
@ApiModel(value="ValMethodConfigureQueryVO对象", description="根据方法类型查询方法配置VO")
public class ValMethodConfigureQueryVO extends BaseQryReqVO {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 方法类型编码
	 */
	@ApiModelProperty(value = "方法类型编码")
	private String classCode;

}
