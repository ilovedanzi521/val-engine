/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodService.java
 * 文件描述: @Description: 估值方法服务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service;


import java.util.List;

import com.win.dfbp.val.manage.entity.ValMethod;

/**   
 * 包名称： com.win.dfbp.val.manage.service 
 * 类名称：ValMethodService 
 * 类描述：估值方法服务类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:42:11
 *     
 */
public interface ValMethodService {
	
	/**
	 * 
	 * @Title: getValMethodList
	 * @Description: 查询所有估值方法
	 * @return   
	 * @return: List<ValMethod>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午11:28:07
	 */
	List<ValMethod> getValMethodList();
}
