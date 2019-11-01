/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationItemService.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.service;

import com.github.pagehelper.PageInfo;
import com.win.dfbp.val.manage.vo.query.ValCalculationItemQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationItemRepVO;

/**
 * 包名称： com.win.dfbp.val.manage.service
 * 类名称：ValCalculationItemService
 * 类描述：ValCalculationItemService服务
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:42:11
 *
 */
public interface ValCalculationItemService {

	/**
	 *
	 * @Title: getValCalculationItems
	 * @Description: 估值计算查询
	 * @param req
	 * @return
	 * @return: PageInfo<ValCalculationItemRepVO>
	 * @throws
	 * @author: huhe
	 * @Date:  2019年10月16日/下午1:55:30
	 */
	PageInfo<ValCalculationItemRepVO> getValCalculationItems(ValCalculationItemQueryVO req);
}
