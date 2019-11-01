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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.win.dfas.common.util.ObjectUtils;
import com.win.dfbp.val.core.constant.TradeRuleConstant;
import com.win.dfbp.val.manage.dao.ValFundConfigureMapper;
import com.win.dfbp.val.manage.dao.ValMethodConfigureMapper;
import com.win.dfbp.val.manage.dao.ValParamConfigureMapper;
import com.win.dfbp.val.manage.entity.ValFundConfigure;
import com.win.dfbp.val.manage.entity.ValMethodConfigure;
import com.win.dfbp.val.manage.entity.ValParamConfigure;
import com.win.dfbp.val.manage.service.ValFundConfigureService;
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValClassMethodRepVO;
import com.win.dfbp.val.manage.vo.respone.ValFundConfigureRepVO;
import com.win.dfbp.val.manage.vo.respone.ValParamMethodRepVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
			valParamConfigureMapper.updateParamMethodConfigure(new ValParamConfigure(
					TradeRuleConstant.VAL_PARAM_DIC_FP001, valParamMethodRepVO.getCostSettlement(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valParamMethodRepVO.getCostSettlementSort())) {
			valParamConfigureMapper.updateParamMethodConfigure(new ValParamConfigure(
					TradeRuleConstant.VAL_PARAM_DIC_FP002, valParamMethodRepVO.getCostSettlementSort(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valParamMethodRepVO.getRealInterestRate())) {
			valParamConfigureMapper.updateParamMethodConfigure(new ValParamConfigure(
					TradeRuleConstant.VAL_PARAM_DIC_FP003, valParamMethodRepVO.getRealInterestRate(), repVO.getId()));
		}
	}

	public void updateValMethodConfigures(ValFundConfigureRepVO repVO) {
		ValClassMethodRepVO valClassMethodRepVO = repVO.getClassMethod();
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getFairPrice())) {
			valMethodConfigureMapper.updateMethodConfigure(new ValMethodConfigure(TradeRuleConstant.VAL_CLASS_DIC_VC002,
					valClassMethodRepVO.getFairPrice(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getCostPrice())) {
			valMethodConfigureMapper.updateMethodConfigure(new ValMethodConfigure(TradeRuleConstant.VAL_CLASS_DIC_VC004,
					valClassMethodRepVO.getCostPrice(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getFloatingProfitLoss())) {
			valMethodConfigureMapper.updateMethodConfigure(new ValMethodConfigure(TradeRuleConstant.VAL_CLASS_DIC_VC005,
					valClassMethodRepVO.getFloatingProfitLoss(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getPositionCost())) {
			valMethodConfigureMapper.updateMethodConfigure(new ValMethodConfigure(TradeRuleConstant.VAL_CLASS_DIC_VC001,
					valClassMethodRepVO.getPositionCost(), repVO.getId()));
		}
		if (StringUtils.isNotEmpty(valClassMethodRepVO.getPositionMarket())) {
			valMethodConfigureMapper.updateMethodConfigure(new ValMethodConfigure(TradeRuleConstant.VAL_CLASS_DIC_VC003,
					valClassMethodRepVO.getPositionMarket(), repVO.getId()));
		}
	}
}
