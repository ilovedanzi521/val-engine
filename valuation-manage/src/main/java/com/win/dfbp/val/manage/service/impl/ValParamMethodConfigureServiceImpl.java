/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValParamMethodConfigureServiceImpl.java
 * 文件描述: @Description: 估值方法管理服务实现
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.win.dfbp.val.manage.dao.ValParamMethodConfigureMapper;
import com.win.dfbp.val.manage.entity.ValParamMethodConfigure;
import com.win.dfbp.val.manage.service.ValParamMethodConfigureService;
import com.win.dfbp.val.manage.vo.query.ValParamMethodConfigureQueryVO;

/**   
 * 包名称： com.win.dfbp.val.manage.service.impl 
 * 类名称：ValParamMethodConfigureServiceImpl 
 * 类描述：估值方法配置服务实现类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:45:03
 *     
 */
@Service
public class ValParamMethodConfigureServiceImpl implements ValParamMethodConfigureService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValParamMethodConfigureService.class);
	@Autowired
	private ValParamMethodConfigureMapper valParamMethodConfigureMapper;
	
	@Override
	public List<ValParamMethodConfigure> getMethodByParam(ValParamMethodConfigureQueryVO queryVO) {
		return valParamMethodConfigureMapper.getMethodByParam(queryVO);
	}	
}
