/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodConfigureMapper.java
 * 文件描述: @Description: 估值分类对应的方法配置
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValMethodConfigure;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValMethodConfigureMapper 
 * 类描述：估值分类对应的方法配置mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValMethodConfigureMapper {
	
	/**
	 * 
	 * @Title: getMethodByFundId
	 * @Description: 根据产品id查询方法配置
	 * @param fundConfigureId
	 * @return   
	 * @return: List<ValMethodConfigure>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/下午6:30:28
	 */
	List<ValMethodConfigure> getMethodByFundId(Integer fundConfigureId);
}
