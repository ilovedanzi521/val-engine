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



import java.io.Serializable;
import java.util.List;

import com.win.dfbp.val.manage.entity.ValParamMethodConfigure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class ValParamMethodConfigureRepVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成本转结方法list
	 */
    @ApiModelProperty(value = "成本结算")
	private List<ValParamMethodConfigure> costSettlements;
    /**
     * 成本核算顺序方法list
     */
    @ApiModelProperty(value = "成本核算顺序")
    private List<ValParamMethodConfigure> costSettlementSorts;
    /**
     * 实际利率方法list
     */
    @ApiModelProperty(value = "实际利率")
    private List<ValParamMethodConfigure> realInterestRates;
   
}
