/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValFundStatusMapper.java
 * 文件描述: @Description: 估值产品状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValFundStatus;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValFundStatusMapper 
 * 类描述：估值产品状态mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValFundStatusMapper {
	
	/**
	 * 
	 * @Title: getValFundStatusList
	 * @Description: 查询所有的产品状态
	 * @return   
	 * @return: List<ValFundStatus>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午10:27:34
	 */
	List<ValFundStatus> getValFundStatusList();
}
