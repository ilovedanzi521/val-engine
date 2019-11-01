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

import com.win.dfbp.val.core.constant.TradeRuleConstant;
import com.win.dfbp.val.manage.dao.ValParamMethodConfigureMapper;
import com.win.dfbp.val.manage.entity.ValParamMethodConfigure;
import com.win.dfbp.val.manage.service.ValParamMethodConfigureService;
import com.win.dfbp.val.manage.vo.respone.ValParamMethodConfigureRepVO;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 包名称： com.win.dfbp.val.manage.service.impl
 * 类名称：ValParamMethodConfigureServiceImpl
 * 类描述：TODO
 * 创建人：@author huhe
 * 创建时间：2019年10月28日/上午11:49:54
 *
 */
@Service
public class ValParamMethodConfigureServiceImpl implements ValParamMethodConfigureService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValParamMethodConfigureService.class);
	@Autowired
	private ValParamMethodConfigureMapper valParamMethodConfigureMapper;

	@Override
	public List<ValParamMethodConfigure> getValParamMethods() {
		return valParamMethodConfigureMapper.getAllParamMethod();
	}

	@Override
	public ValParamMethodConfigureRepVO getMethodByParam() {
		List<ValParamMethodConfigure> valParamMethodConfigures = valParamMethodConfigureMapper.getAllParamMethod();
		List<ValParamMethodConfigure> costSettlements = new ArrayList<ValParamMethodConfigure>();
		List<ValParamMethodConfigure> costSettlementSorts = new ArrayList<ValParamMethodConfigure>();
		List<ValParamMethodConfigure> realInterestRates = new ArrayList<ValParamMethodConfigure>();
		ValParamMethodConfigureRepVO configureReqVO = new ValParamMethodConfigureRepVO();
		if (CollectionUtils.isNotEmpty(valParamMethodConfigures)) {
			for (ValParamMethodConfigure valParamMethodConfigure : valParamMethodConfigures) {
				switch (valParamMethodConfigure.getParamCode()) {
				case TradeRuleConstant.VAL_PARAM_DIC_FP001:
					costSettlements.add(valParamMethodConfigure);
					break;
				case TradeRuleConstant.VAL_PARAM_DIC_FP002:
					costSettlementSorts.add(valParamMethodConfigure);
					break;
				case TradeRuleConstant.VAL_PARAM_DIC_FP003:
					realInterestRates.add(valParamMethodConfigure);
					break;
				default:
					LOGGER.error("估值标准参数方法错误");
					break;
				}
			}
			configureReqVO.setCostSettlements(costSettlements);
			configureReqVO.setCostSettlementSorts(costSettlementSorts);
			configureReqVO.setRealInterestRates(realInterestRates);
		}
		return configureReqVO;
	}
}
