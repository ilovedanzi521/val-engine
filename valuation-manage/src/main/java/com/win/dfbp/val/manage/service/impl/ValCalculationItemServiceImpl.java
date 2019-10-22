/****************************************************
 * 创建人：     @author huhe
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValCalculationItemServiceImpl.java
 * 文件描述: @Description: TODO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.win.dfas.common.util.ObjectUtils;
import com.win.dfbp.val.manage.dao.ValCalculationItemMapper;
import com.win.dfbp.val.manage.dao.ValItemMapper;
import com.win.dfbp.val.manage.entity.ValItem;
import com.win.dfbp.val.manage.service.ValCalculationItemService;
import com.win.dfbp.val.manage.vo.query.ValCalculationItemQueryVO;
import com.win.dfbp.val.manage.vo.respone.ValCalculationItemRepVO;

/**
 * 包名称： com.win.dfbp.val.manage.service.impl
 * 类名称：ValCalculationItemServiceImpl
 * 类描述：TODO
 * 创建人：@author huhe
 * 创建时间：2019年10月16日/下午1:45:03
 *
 */
@Service
public class ValCalculationItemServiceImpl implements ValCalculationItemService {

	@Autowired
	private ValCalculationItemMapper valCalculationItemMapper;
	@Autowired
	private ValItemMapper valItemMapper;

	@Override
	public PageInfo<ValCalculationItemRepVO> getValCalculationItems(ValCalculationItemQueryVO reqVO) {
		PageHelper.startPage(reqVO.getReqPageNum(), reqVO.getReqPageSize());
		List<ValCalculationItemRepVO> list = valCalculationItemMapper.getValCalculationItems(reqVO);
		for (ValCalculationItemRepVO valCalculationItemRepVO : list) {
			if (StringUtils.isNotEmpty(valCalculationItemRepVO.getCalFormula())) {
				valCalculationItemRepVO.setCalFormulaStr(translateCalFormula(valCalculationItemRepVO.getCalFormula()));
			}
		}
		PageInfo<ValCalculationItemRepVO> pageInfo = new PageInfo<>(list);
		return ObjectUtils.copyPageInfo(pageInfo, ValCalculationItemRepVO.class, true);
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

}
