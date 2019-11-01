/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValFundStatusServiceImpl.java
 * 文件描述: @Description: 估值产品状态服务实现
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.service.impl;

import com.win.dfbp.val.manage.dao.ValFundStatusMapper;
import com.win.dfbp.val.manage.entity.ValFundStatus;
import com.win.dfbp.val.manage.service.ValFundStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名称： com.win.dfbp.val.manage.service.impl
 * 类名称：ValFundStatusServiceImpl
 * 类描述：估值产品状态服务实现类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:45:03
 *
 */
@Service
public class ValFundStatusServiceImpl implements ValFundStatusService {

	@Autowired
	private ValFundStatusMapper valFundStatusMapper;


	@Override
	public List<ValFundStatus> getValFundStatusList() {
		return valFundStatusMapper.getValFundStatusList();
	}

}
