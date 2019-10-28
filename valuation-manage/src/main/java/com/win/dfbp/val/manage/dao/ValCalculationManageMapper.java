/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/上午11:37:19
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationManageMapper.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.win.dfbp.val.manage.entity.ValMethod;
import com.win.dfbp.val.manage.vo.query.ValCalculationItemQueryVO;
import com.win.dfbp.val.manage.vo.query.ValCalculationManageQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationItemRepVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationManageRepVO;
import com.win.dfbp.val.manage.vo.respone.ValClassMethodConfigureReqVO;

/**   
 * 包名称： com.win.dfbp.val.manage.dao 
 * 类名称：ValCalculationManageMapper 
 * 类描述：估值方法管理mapper
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/上午11:37:19
 *     
 */
@Mapper
public interface ValCalculationManageMapper {
	
	/**
	 * 
	 * @Title: getValCalculationManages
	 * @Description: 查询估值方法管理列表
	 * @param reqVO
	 * @return   
	 * @return: List<ValCalculationManageRepVO>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午9:06:49
	 */
	List<ValCalculationManageRepVO> getValCalculationManages(ValCalculationManageQueryVO reqVO);
	
	/**
	 * 
	 * @Title: getMethodByClass
	 * @Description: 根据类型查询方法
	 * @param 
	 * @return   
	 * @return: List<ValClassMethodConfigureReqVO>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月25日/下午5:03:17
	 */
	List<ValClassMethodConfigureReqVO> getMethodByClass();
	
	/**
	 * 
	 * @Title: updataCalculationManage
	 * @Description: 更新管理方法
	 * @param reqVO   
	 * @return: void   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午9:39:48
	 */
	void updataCalculationManage(ValCalculationManageQueryVO reqVO);
	
}
