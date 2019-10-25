/****************************************************
 * 创建人: @author huhe    
 * 创建时间: 2019-10-11/11:17
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValClassEnum.java
 * 文件描述: @Description: 字典枚举类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.enumeration;


/**
 * 包名称：com.win.dfbp.val.manage.enumeration
 * 类名称：ValClassEnum
 * 类描述：字典类型枚举类
 * 创建人：@author zoujian
 * 创建时间：2019-10-11/11:17
 */
public enum ValClassEnum {
	/**
	 * 持仓成本
	 */
	POSITION_COST("VC001", "持仓成本"),
	/**
	 * 公允价
	 */
	FAIR_PRICE("VC002", "公允价"),
	/**
	 * 持仓市值
	 */
	POSITION_MARKET("VC003", "持仓市值"),
	/**
	 * 成本价
	 */
	COST_PRICE("VC004", "成本价"),
	/**
	 * 浮动盈亏
	 */
	FLOAT_PROFIT_LOSS("VC005", "浮动盈亏");
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

	private ValClassEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static String getCode(String desc) {
		String code = null;
		for (ValClassEnum valClassEnum : ValClassEnum.values()) {
			if (valClassEnum.desc.equals(desc)) {
				code = valClassEnum.getCode();
				break;
			}
		}
		return code;
	}

}
