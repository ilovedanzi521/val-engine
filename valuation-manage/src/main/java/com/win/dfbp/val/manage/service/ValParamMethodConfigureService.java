/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValParamMethodConfigureService.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.win.dfbp.val.manage.entity.ValFundConfigure;
import com.win.dfbp.val.manage.entity.ValParamMethodConfigure;
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;
import com.win.dfbp.val.manage.vo.query.ValParamMethodConfigureQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValFundConfigureRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.service 
 * 类名称：ValParamMethodConfigureService 
 * 类描述：ValParamMethodConfigureService服务
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:42:11
 *     
 */
public interface ValParamMethodConfigureService {
	
	/**
	 * 
	 * @Title: getMethodByParam
	 * @Description: 根据参数查询配置方法
	 * @param queryVO
	 * @return   
	 * @return: List<ValParamMethodConfigure>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月23日/上午10:03:59
	 */
	List<ValParamMethodConfigure> getMethodByParam(ValParamMethodConfigureQueryVO queryVO);
	
}
