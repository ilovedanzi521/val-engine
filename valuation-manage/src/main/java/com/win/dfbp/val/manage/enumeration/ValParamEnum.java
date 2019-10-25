/****************************************************
 * 创建人: @author huhe    
 * 创建时间: 2019-10-11/11:17
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValParamEnum.java
 * 文件描述: @Description: 字典枚举类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.enumeration;


/**
 * 
 * 包名称： com.win.dfbp.val.manage.enumeration 
 * 类名称：ValParamEnum 
 * 类描述：字典参数类
 * 创建人：@author huhe 
 * 创建时间：2019年10月23日/下午8:11:11
 *
 */

public enum ValParamEnum {
	
	/**
	 * 成本结转
	 */
	COST_SETTLEMENT("FP001","成本结转"),
    /**
     * 成本核算顺序
     */
	COST_SETTLEMENT_SORT("FP002","成本核算顺序"),
    /**
     * 实际利率
     */
	REAL_INTEREST_RATE("FP003","实际利率");
	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private ValParamEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static String getCode(String desc) {
		String code = null;
		for (ValParamEnum valClassEnum : ValParamEnum.values()) {
			if (valClassEnum.desc.equals(desc)) {
				code = valClassEnum.getCode();
				break;
			}
		}
		return code;
	}

}
