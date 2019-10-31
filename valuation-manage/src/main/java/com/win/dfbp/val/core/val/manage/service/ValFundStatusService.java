/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValFundStatusService.java
 * 文件描述: @Description: 估值产品状态服务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.core.val.manage.service;


import java.util.List;

import com.win.dfbp.val.core.val.manage.entity.ValFundStatus;

/**
 * 包名称： com.win.dfbp.val.manage.service
 * 类名称：ValFundStatusService
 * 类描述：估值产品状态服务类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:42:11
 *
 */
public interface ValFundStatusService {

	/**
	 *
	 * @Title: getValFundStatusList
	 * @Description: 查询所有估值产品状态
	 * @return
	 * @return: List<ValFundStatus>
	 * @throws
	 * @author: huhe
	 * @Date:  2019年10月17日/上午11:28:07
	 */
	List<ValFundStatus> getValFundStatusList();
}
