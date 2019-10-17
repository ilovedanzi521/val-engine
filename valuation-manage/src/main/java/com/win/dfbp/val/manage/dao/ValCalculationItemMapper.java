/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationItemMapper.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.vo.query.ValCalculationItemQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationItemRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValCalculationItemMapper 
 * 类描述：计算项mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValCalculationItemMapper {
	
	/**
	 * 
	 * @Title: getValCalculationItems
	 * @Description: 估值计算项列表查询
	 * @param reqVO
	 * @return   
	 * @return: List<ValCalculationItemRepVO>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月16日/下午1:43:17
	 */
	List<ValCalculationItemRepVO> getValCalculationItems(ValCalculationItemQueryVO reqVO);
	
	/**
	 * 更新统计方式
	 * @Title: updataCalculationItem
	 * @Description: TODO
	 * @param reqVO   
	 * @return: void   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午9:44:10
	 */
	void updataCalculationItem(ValCalculationItemQueryVO reqVO);
}
