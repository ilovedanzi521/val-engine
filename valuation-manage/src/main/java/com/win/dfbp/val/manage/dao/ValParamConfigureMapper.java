/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValParamConfigureMapper.java
 * 文件描述: @Description: 产品估值配置
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValParamMethodConfigure;
import com.win.dfbp.val.manage.vo.respone.ValParamMethodRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValParamConfigureMapper 
 * 类描述：产品估值配置mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValParamConfigureMapper {
	
	/**
	 * 
	 * @Title: getParamByFundId
	 * @Description: 根据产品id查询参数配置(列转行)
	 * @param fundId
	 * @return   
	 * @return: ValParamMethodRepVO   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/下午6:30:28
	 */
	ValParamMethodRepVO getParamByFundId(Long fundId);
	
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
