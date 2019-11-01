/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:19:03
 * 项目名称：  valuation-manage
 * 文件名称: ValFundConfigureQueryVO.java
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
 * 类名称：ValFundConfigureQueryVO
 * 类描述：产品估值配置VO
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:19:03
 *
 */
@Data
@ApiModel(value="ValFundConfigureQueryVO对象", description="产品估值配置查询条件VO")
public class ValFundConfigureQueryVO extends BaseQryReqVO {

	private static final long serialVersionUID = 1L;
	/**
	 * 产品编码
	 */
	@ApiModelProperty(value = "产品编码")
	private String fundNo;
	/**
	 * 产品状态
	 */
	@ApiModelProperty(value = "产品状态")
	private Integer fundStatus;

	/**
	 * 产品名称（只有模糊查询时使用）
	 */
	@ApiModelProperty(value = "产品名称")
	private String fundName;
}
