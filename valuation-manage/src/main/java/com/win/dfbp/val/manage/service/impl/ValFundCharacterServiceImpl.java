/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:45:03
 * 项目名称：  valuation-manage
 * 文件名称: ValFundCharacterServiceImpl.java
 * 文件描述: @Description: 估值产品性质服务实现
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.dfbp.val.manage.dao.ValFundCharacterMapper;
import com.win.dfbp.val.manage.entity.ValFundCharacter;
import com.win.dfbp.val.manage.service.ValFundCharacterService;

/**   
 * 包名称： com.win.dfbp.val.manage.service.impl 
 * 类名称：ValFundCharacterServiceImpl 
 * 类描述：估值产品性质服务实现类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:45:03
 *     
 */
@Service
public class ValFundCharacterServiceImpl implements ValFundCharacterService {
	
	@Autowired
	private ValFundCharacterMapper valFundCharacterMapper;

	
	@Override
	public List<ValFundCharacter> getValFundCharacterList() {
		return valFundCharacterMapper.getValFundCharacterList();
	}
		
}
