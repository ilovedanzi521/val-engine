/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValFundConfigureServiceImpl.java
 * 文件描述: @Description: 估值方法管理服务实现
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.win.dfas.common.util.ObjectUtils;
import com.win.dfbp.val.manage.dao.ValFundConfigureMapper;
import com.win.dfbp.val.manage.dao.ValMethodConfigureMapper;
import com.win.dfbp.val.manage.dao.ValParamConfigureMapper;
import com.win.dfbp.val.manage.entity.ValFundConfigure;
import com.win.dfbp.val.manage.service.ValFundConfigureService;
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValClassMethodRepVO;
import com.win.dfbp.val.manage.vo.respone.ValFundConfigureRepVO;
import com.win.dfbp.val.manage.vo.respone.ValParamMethodRepVO;

/**   
 * 包名称： com.win.dfbp.val.manage.service.impl 
 * 类名称：ValFundConfigureServiceImpl 
 * 类描述：估值方法配置服务实现类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:45:03
 *     
 */
@Service
public class ValFundConfigureServiceImpl implements ValFundConfigureService {
	
	@Autowired
	private ValFundConfigureMapper valFundConfigureMapper;
	@Autowired
	private ValMethodConfigureMapper valMethodConfigureMapper;
	@Autowired
	private ValParamConfigureMapper valParamConfigureMapper;
	
	@Override
	public PageInfo<ValFundConfigureRepVO> getValFundConfigures(ValFundConfigureQueryVO reqVO) {
		PageHelper.startPage(reqVO.getReqPageNum(), reqVO.getReqPageSize());
		List<ValFundConfigureRepVO> list = valFundConfigureMapper.getValFundConfigureList(reqVO);
		for (ValFundConfigureRepVO valFundConfigureRepVO : list) {
			ValClassMethodRepVO classMethod = valMethodConfigureMapper.getMethodByFundId(valFundConfigureRepVO.getId());
			ValParamMethodRepVO paramMethod = valParamConfigureMapper.getParamByFundId(valFundConfigureRepVO.getId());
			if (null != classMethod) {
				valFundConfigureRepVO.setClassMethod(classMethod);
			}
			if (null != paramMethod) {
				valFundConfigureRepVO.setParamMethod(paramMethod);
			}
		}
		PageInfo<ValFundConfigureRepVO> pageInfo = new PageInfo<>(list);
		return ObjectUtils.copyPageInfo(pageInfo, ValFundConfigureRepVO.class, true);
	}

	@Override
	public List<ValFundConfigure> getValFundAll() {
		return valFundConfigureMapper.getValFundAll();
	}
	
}
