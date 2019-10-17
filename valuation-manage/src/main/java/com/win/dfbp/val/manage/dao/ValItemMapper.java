/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValItemMapper.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValItem;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValItemMapper 
 * 类描述：计算因子mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValItemMapper {
	
	/**
	 * 
	 * @Title: getValItems
	 * @Description: 查询层级为1的计算因子
	 * @return   
	 * @return: List<ValItem>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月16日/下午3:53:51
	 */
	List<ValItem> getValItems();
}
