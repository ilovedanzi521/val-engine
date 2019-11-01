/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationManageServiceImpl.java
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
import com.win.dfbp.val.manage.dao.ValCalculationManageMapper;
import com.win.dfbp.val.manage.dao.ValItemMapper;
import com.win.dfbp.val.manage.entity.ValItem;
import com.win.dfbp.val.manage.service.ValCalculationManageService;
import com.win.dfbp.val.manage.vo.query.ValCalculationManageQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationManageRepVO;
import com.win.dfbp.val.manage.vo.respone.ValClassMethodConfigureReqVO;
import com.win.dfbp.val.manage.vo.respone.ValMethodConfigureRepVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名称： com.win.dfbp.val.manage.service.impl
 * 类名称：ValCalculationManageServiceImpl
 * 类描述：估值方法管理服务实现类
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:45:03
 *
 */
@Service
public class ValCalculationManageServiceImpl implements ValCalculationManageService {

	@Autowired
	private ValCalculationManageMapper valCalculationManageMapper;
	@Autowired
	private ValItemMapper valItemMapper;

	@Override
	public PageInfo<ValCalculationManageRepVO> getValCalculationManages(ValCalculationManageQueryVO reqVO) {
		PageHelper.startPage(reqVO.getReqPageNum(), reqVO.getReqPageSize());
		List<ValCalculationManageRepVO> list = valCalculationManageMapper.getValCalculationManages(reqVO);
		for (ValCalculationManageRepVO valCalculationManageRepVO : list) {
			if (StringUtils.isNotEmpty(valCalculationManageRepVO.getCalFormula())) {
				valCalculationManageRepVO
						.setCalFormulaStr(translateCalFormula(valCalculationManageRepVO.getCalFormula()));
			}
		}
		PageInfo<ValCalculationManageRepVO> pageInfo = new PageInfo<>(list);
		return ObjectUtils.copyPageInfo(pageInfo, ValCalculationManageRepVO.class, true);
	}

	public String translateCalFormula(String calFormula) {
		List<ValItem> valItems = valItemMapper.getValItems();
		for (ValItem valItem : valItems) {
			if (calFormula.contains(valItem.getItemCode())) {
				calFormula = calFormula.replaceAll(valItem.getItemCode(), valItem.getItemName());
			}
		}
		return calFormula;
	}

	@Override
	public ValMethodConfigureRepVO getMethodByClass() {
		List<ValClassMethodConfigureReqVO> methods = valCalculationManageMapper.getMethodByClass();
		ValMethodConfigureRepVO configureRepVO = new ValMethodConfigureRepVO();
		List<ValClassMethodConfigureReqVO> positionCosts = new ArrayList<ValClassMethodConfigureReqVO>();
		List<ValClassMethodConfigureReqVO> fairPrices = new ArrayList<ValClassMethodConfigureReqVO>();
		List<ValClassMethodConfigureReqVO> positionMarkets = new ArrayList<ValClassMethodConfigureReqVO>();
		List<ValClassMethodConfigureReqVO> costPrices = new ArrayList<ValClassMethodConfigureReqVO>();
		List<ValClassMethodConfigureReqVO> floatingProfitLoss = new ArrayList<ValClassMethodConfigureReqVO>();
		if (CollectionUtils.isNotEmpty(methods)) {
			for (ValClassMethodConfigureReqVO method : methods) {
				switch (method.getClassCode()) {
				case TradeRuleConstant.VAL_CLASS_DIC_VC001:
					positionCosts.add(method);
					break;
				case TradeRuleConstant.VAL_CLASS_DIC_VC002:
					fairPrices.add(method);
					break;
				case TradeRuleConstant.VAL_CLASS_DIC_VC003:
					positionMarkets.add(method);
					break;
				case TradeRuleConstant.VAL_CLASS_DIC_VC004:
					costPrices.add(method);
					break;
				case TradeRuleConstant.VAL_CLASS_DIC_VC005:
					floatingProfitLoss.add(method);
					break;
				default:
					break;
				}
			}
			configureRepVO.setPositionCosts(positionCosts);
			configureRepVO.setFairPrices(fairPrices);
			configureRepVO.setPositionMarkets(positionMarkets);
			configureRepVO.setCostPrices(costPrices);
			configureRepVO.setFloatingProfitLoss(floatingProfitLoss);
		}
		return configureRepVO;
	}

}
