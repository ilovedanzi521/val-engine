/****************************************************
 * 创建人：     @author hechengcheng
 * 创建时间: 2019年5月31日/下午3:19:16
 * 项目名称：  dfbp-common-basicparameter
 * 文件名称: StatusEnum.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.core.val.manage.enumeration;

/**
 * 包名称： com.win.dfbp.basicparameter.enumeration
 * 类名称：StatusEnum
 * 类描述：状态枚举, 涉及到状态的枚举都定义在这里
 * 创建人：@author hechengcheng
 * 创建时间：2019年5月31日/下午3:19:16
 *
 */
public interface StatusEnum {

	/**
	 * 开关状态枚举
	 *
	 * 包名称： com.win.dfbp.basicparameter.enumeration
	 * 类名称：SwitchStatusEnum
	 * 类描述：TODO
	 * 创建人：@author hechengcheng
	 * 创建时间：2019年5月31日/下午3:20:38
	 *
	 */
	public enum SwitchStatusEnum {

		// 开关枚举
		SWITCH_STATUS_OPEN(0, "开启"),
		SWITCH_STATUS_CLOSE(1, "关闭"),
	    ;

	    private Integer status;
	    private String value;

	    SwitchStatusEnum(Integer status, String value) {
	        this.status = status;
	        this.value = value;
	    }

	    public Integer getStatus() {
			return status;
		}

		public String getValue() {
	        return value;
	    }

		public static String getValue(Integer status) {

			String value = null;

			for(SwitchStatusEnum statusEnum : SwitchStatusEnum.values()) {
				if (statusEnum.status.equals(status)) {
					value = statusEnum.getValue();
					break;
				}
			}

			return value;
		}
	}

	/**
	 * 缓存状态枚举
	 *
	 * 包名称： com.win.dfbp.basicparameter.enumeration
	 * 类名称：CacheStatusEnum
	 * 类描述：TODO
	 * 创建人：@author hechengcheng
	 * 创建时间：2019年5月31日/下午3:20:38
	 *
	 */
	public enum CacheStatusEnum {

		// 缓存状态枚举
		CACHE_STATUS_SUCCESS(0, "成功"),
		CACHE_STATUS_FAILED(1, "失败"),
		;

		private Integer status;
		private String value;

		CacheStatusEnum(Integer status, String value) {
			this.status = status;
			this.value = value;
		}

		public Integer getStatus() {
			return status;
		}

		public String getValue() {
			return value;
		}

		public static String getValue(Integer status) {

			String value = null;

			for(CacheStatusEnum statusEnum : CacheStatusEnum.values()) {
				if (statusEnum.status.equals(status)) {
					value = statusEnum.getValue();
					break;
				}
			}

			return value;
		}
	}
}
