/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValClassService.java
 * 文件描述: @Description: 估值分类服务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.win.dfbp.val.manage.entity.ValClass;
import com.win.dfbp.val.manage.vo.query.ValCalculationManageQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationManageRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.service 
 * 类名称：ValClassService 
 * 类描述：估值分类服务类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:42:11
 *     
 */
public interface ValClassService {
	
	/**
	 * 
	 * @Title: getValClassList
	 * @Description: 查询所有的分类
	 * @return   
	 * @return: List<ValClass>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午10:27:34
	 */
	List<ValClass> getValClassList();
}
