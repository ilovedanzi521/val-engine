/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValFundConfigureService.java
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
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValFundConfigureRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.service 
 * 类名称：ValFundConfigureService 
 * 类描述：ValFundConfigureService服务
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:42:11
 *     
 */
public interface ValFundConfigureService {
	
	/**
	 * 
	 * @Title: getValFundAll
	 * @Description: 查询所有产品
	 * @return   
	 * @return: List<ValFundConfigure>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月22日/上午11:03:18
	 */
	List<ValFundConfigure> getValFundAll();
	
	/**
	 * 
	 * @Title: getValFundConfigures
	 * @Description: 产品估值配置查询
	 * @param reqVO
	 * @return   
	 * @return: PageInfo<ValFundConfigureRepVO>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月18日/下午4:59:49
	 */
	PageInfo<ValFundConfigureRepVO> getValFundConfigures(ValFundConfigureQueryVO reqVO);
}
