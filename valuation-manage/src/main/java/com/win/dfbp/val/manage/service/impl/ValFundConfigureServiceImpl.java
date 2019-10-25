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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.win.dfas.common.util.ObjectUtils;
import com.win.dfbp.val.manage.dao.ValFundConfigureMapper;
import com.win.dfbp.val.manage.dao.ValMethodConfigureMapper;
import com.win.dfbp.val.manage.dao.ValParamConfigureMapper;
import com.win.dfbp.val.manage.entity.ValFundConfigure;
import com.win.dfbp.val.manage.entity.ValMethodConfigure;
import com.win.dfbp.val.manage.entity.ValParamConfigure;
import com.win.dfbp.val.manage.enumeration.ValClassEnum;
import com.win.dfbp.val.manage.enumeration.ValParamEnum;
import com.win.dfbp.val.manage.service.ValFundConfigureService;
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValClassMethodRepVO;
import com.win.dfbp.val.manage.vo.respone.ValFundConfigureRepVO;
import com.win.dfbp.val.manage.vo.respone.ValParamMethodRepVO;

import io.swagger.annotations.ApiModelProperty;

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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValFundConfigureServiceImpl.class);
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

	
	@Override
	public void updateFundConfigure(ValFundConfigureRepVO repVO) {
		valFundConfigureMapper.updateFundConfigure(repVO);
		if (repVO.getParamMethod() != null) {
			this.updateValParamConfigures(repVO);
		}
		if (repVO.getClassMethod() != null) {
			this.updateValMethodConfigures(repVO);
		}
	}

	public void updateValParamConfigures(ValFundConfigureRepVO repVO) {
		ValParamMethodRepVO valParamMethodRepVO = repVO.getParamMethod();
		if (StringUtils.isNotEmpty(valParamMethodRepVO.getCostSettlement())) {
			valParamConfigureMapper.updateParamMethodConfigure(this.getValParamConfigure(
					ValParamEnum.COST_SETTLEMENT.getCode(), valParamMethodRepVO.getCostSettlement(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valParamMethodRepVO.getCostSettlementSort())) {
			valParamConfigureMapper
					.updateParamMethodConfigure(this.getValParamConfigure(ValParamEnum.COST_SETTLEMENT_SORT.getCode(),
							valParamMethodRepVO.getCostSettlementSort(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valParamMethodRepVO.getRealInterestRate())) {
			valParamConfigureMapper.updateParamMethodConfigure(this.getValParamConfigure(
					ValParamEnum.REAL_INTEREST_RATE.getCode(), valParamMethodRepVO.getRealInterestRate(), repVO.getId()));
		}
	}

	public void updateValMethodConfigures(ValFundConfigureRepVO repVO) {
		ValClassMethodRepVO valClassMethodRepVO = repVO.getClassMethod();
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getFairPrice())) {
			valMethodConfigureMapper.updateMethodConfigure(this.getValMethodConfigure(ValClassEnum.FAIR_PRICE.getCode(),
					valClassMethodRepVO.getFairPrice(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getCostPrice())) {
			valMethodConfigureMapper.updateMethodConfigure(this.getValMethodConfigure(ValClassEnum.COST_PRICE.getCode(),
					valClassMethodRepVO.getCostPrice(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getFloatingProfitLoss())) {
			valMethodConfigureMapper
					.updateMethodConfigure(this.getValMethodConfigure(ValClassEnum.FLOAT_PROFIT_LOSS.getCode(),
							valClassMethodRepVO.getFloatingProfitLoss(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getPositionCost())) {
			valMethodConfigureMapper.updateMethodConfigure(this.getValMethodConfigure(
					ValClassEnum.POSITION_COST.getCode(), valClassMethodRepVO.getPositionCost(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getPositionMarket())) {
			valMethodConfigureMapper.updateMethodConfigure(this.getValMethodConfigure(
					ValClassEnum.POSITION_MARKET.getCode(), valClassMethodRepVO.getPositionMarket(), repVO.getId()));
		}
	}

	public ValMethodConfigure getValMethodConfigure(String classCode, String methodCode, long fundConfigureId) {
		ValMethodConfigure valMethodConfigure = new ValMethodConfigure();
		valMethodConfigure.setFundConfigureId(fundConfigureId);
		valMethodConfigure.setMethodCode(methodCode);
		valMethodConfigure.setClassCode(classCode);
		return valMethodConfigure;
	}

	public ValParamConfigure getValParamConfigure(String paramCode, String methodCode, long fundConfigureId) {
		ValParamConfigure valParamConfigure = new ValParamConfigure();
		valParamConfigure.setFundConfigureId(fundConfigureId);
		valParamConfigure.setMethodCode(methodCode);
		valParamConfigure.setParamCode(paramCode);
		return valParamConfigure;
	}
}
