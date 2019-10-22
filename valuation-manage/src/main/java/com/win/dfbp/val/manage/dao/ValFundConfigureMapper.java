/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValFundConfigureMapper.java
 * 文件描述: @Description: 估值产品
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValFundConfigure;
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValFundConfigureRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValFundConfigureMapper 
 * 类描述：估值产品mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValFundConfigureMapper {
	
	/**
	 * 
	 * @Title: getValFundConfigureList
	 * @Description: 查询产品估值配置
	 * @param reqVO
	 * @return   
	 * @return: List<ValFundConfigureRepVO>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月18日/下午5:07:41
	 */
	List<ValFundConfigureRepVO> getValFundConfigureList(ValFundConfigureQueryVO reqVO);

	/**
	 * @Title: getValFundAll
	 * @Description: 查询所有产品配置
	 * @return   
	 * @return: List<ValFundConfigure>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月22日/上午11:04:21 
	 */
	
	List<ValFundConfigure> getValFundAll();
}
