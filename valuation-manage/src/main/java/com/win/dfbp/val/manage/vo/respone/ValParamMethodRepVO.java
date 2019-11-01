/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:04:53
 * 项目名称：  valuation-manage
 * 文件名称: ValParamMethodRepVO.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.vo.respone;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.win.dfbp.val.manage.vo.respone
 * 类名称：ValParamMethodRepVO
 * 类描述：估值参数方法行转列
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:04:53
 *
 */
@Data
@ApiModel(value = "ValParamMethodRepVO对象", description = "估值参数方法行转列VO")
public class ValParamMethodRepVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 成本结算对应的method_code
     */
    @ApiModelProperty(value = "成本结算")
	private String costSettlement;
    /**
     * 成本核算顺序对应的method_code
     */
    @ApiModelProperty(value = "成本核算顺序")
	private String costSettlementSort;
    /**
     * 实际利率对应的method_code
     */
    @ApiModelProperty(value = "实际利率")
	private String realInterestRate;
    /**
     * 成本结算对应的方法名称
     */
    @ApiModelProperty(value = "成本结算方法名称")
	private String costSettlementName;
    /**
     * 成本核算顺序对应的方法名称
     */
    @ApiModelProperty(value = "成本核算顺序方法名称")
	private String costSettlementSortName;
    /**
     * 实际利率对应的方法名称
     */
    @ApiModelProperty(value = "实际利率方法名称")
	private String realInterestRateName;


}
