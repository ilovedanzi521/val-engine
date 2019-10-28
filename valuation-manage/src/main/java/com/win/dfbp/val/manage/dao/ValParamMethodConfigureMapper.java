/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValParamMethodConfigureMapper.java
 * 文件描述: @Description: 估值产品
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValParamMethodConfigure;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValParamMethodConfigureMapper 
 * 类描述：参数方法配置mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValParamMethodConfigureMapper {
	
	/**
	 * 查询参数方法
	 * @Title: getAllParamMethod
	 * @Description: TODO
	 * @return   
	 * @return: List<ValParamMethodConfigure>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月21日/下午6:19:33
	 */
	List<ValParamMethodConfigure> getAllParamMethod();
}
