/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValParamDictionaryMapper.java
 * 文件描述: @Description: 估值参数
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import com.win.dfbp.val.manage.entity.ValParamDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包名称： com.win.dfbp.val.manage.dao
 * 类名称：ValParamDictionaryMapper
 * 类描述：估值参数mapper
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/上午11:37:19
 *
 */
@Mapper
public interface ValParamDictionaryMapper {

	/**
	 *
	 * @Title: getValParamDictionaryList
	 * @Description: 查询所有的参数
	 * @return
	 * @return: List<ValParamDictionary>
	 * @throws
	 * @author: huhe
	 * @Date:  2019年10月17日/上午10:27:34
	 */
	List<ValParamDictionary> getValParamDictionaryList();
}
