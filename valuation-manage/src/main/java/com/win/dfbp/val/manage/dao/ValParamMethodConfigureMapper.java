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
import com.win.dfbp.val.manage.vo.query.ValParamMethodConfigureQueryVO;

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
	 * 
	 * @Title: getMethodByParam
	 * @Description: TODO
	 * @param queryVO
	 * @return   
	 * @return: List<ValParamMethodConfigure>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月23日/上午10:10:25
	 */
	List<ValParamMethodConfigure> getMethodByParam(ValParamMethodConfigureQueryVO queryVO);
}
