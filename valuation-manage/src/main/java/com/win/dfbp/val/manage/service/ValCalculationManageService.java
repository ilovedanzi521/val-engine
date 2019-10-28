/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationManageService.java
 * 文件描述: @Description: 估值方法管理服务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service;

import com.github.pagehelper.PageInfo;
import com.win.dfbp.val.manage.vo.query.ValCalculationManageQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationManageRepVO;
import com.win.dfbp.val.manage.vo.respone.ValMethodConfigureRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.service 
 * 类名称：ValCalculationManageService 
 * 类描述：估值方法管理服务类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:42:11
 *     
 */
public interface ValCalculationManageService {
	
	/**
	 * 
	 * @Title: getValCalculationManages
	 * @Description: 估值方法管理列表
	 * @param reqVO
	 * @return   
	 * @return: PageInfo<ValCalculationManageRepVO>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午10:07:26
	 */
	PageInfo<ValCalculationManageRepVO> getValCalculationManages(ValCalculationManageQueryVO reqVO);
	
	/**
	 * 
	 * @Title: getMethodByClass
	 * @Description: 根据类型查询方法
	 * @return   
	 * @return: ValMethodConfigureRepVO   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月28日/上午11:52:51
	 */
	ValMethodConfigureRepVO getMethodByClass();
}
