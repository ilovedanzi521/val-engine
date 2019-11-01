/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodMapper.java
 * 文件描述: @Description: 估值方法
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import com.win.dfbp.val.manage.entity.ValMethod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包名称： com.win.dfbp.val.manage.dao
 * 类名称：ValMethodMapper
 * 类描述：估值方法mapper
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:37:19
 *
 */
@Mapper
public interface ValMethodMapper {

	/**
	 *
	 * @Title: getValMethodList
	 * @Description: 查询所有的方法
	 * @return
	 * @return: List<ValMethod>
	 * @throws
	 * @author: huhe
	 * @Date:  2019年10月17日/上午10:27:34
	 */
	List<ValMethod> getValMethodList();
}
