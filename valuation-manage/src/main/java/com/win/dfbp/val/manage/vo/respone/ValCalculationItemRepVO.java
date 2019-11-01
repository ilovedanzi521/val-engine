/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:04:53
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationItemRepVO.java
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

import javax.validation.constraints.NotNull;

/**
 * 包名称： com.win.dfbp.val.manage.vo.respone
 * 类名称：ValCalculationItemRepVO
 * 类描述：TODO
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:04:53
 *
 */
@Data
@ApiModel(value = "ValCalculationItemRepVO对象", description = "估值计算")
public class ValCalculationItemRepVO extends BaseRepVO {

	private static final long serialVersionUID = 1L;
	/**
     * 计算项
     */
    @ApiModelProperty(value = "计算项")
    @NotNull(message = "计算项")
	private String calItem;
    @ApiModelProperty(value = "计算项名称")
    @NotNull(message = "计算项名称")
    private String itemName;
    /**
     * 计算公式
     */
    @ApiModelProperty(value = "计算公式")
	private String calFormula;
    /**
     * 计算公式翻译字段
     */
    @ApiModelProperty(value = "计算公式翻译字段")
   	private String calFormulaStr;

}
