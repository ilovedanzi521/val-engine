/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValMethodServiceImpl.java
 * 文件描述: @Description: 估值方法服务实现
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.service.impl;

import com.win.dfbp.val.manage.dao.ValMethodMapper;
import com.win.dfbp.val.manage.entity.ValMethod;
import com.win.dfbp.val.manage.service.ValMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名称： com.win.dfbp.val.manage.service.impl
 * 类名称：ValMethodServiceImpl
 * 类描述：估值方法服务实现类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:45:03
 *
 */
@Service
public class ValMethodServiceImpl implements ValMethodService {

	@Autowired
	private ValMethodMapper valMethodMapper;


	@Override
	public List<ValMethod> getValMethodList() {
		return valMethodMapper.getValMethodList();
	}

}
