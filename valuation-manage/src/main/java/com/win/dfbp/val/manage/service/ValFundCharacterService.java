/****************************************************
 * 创建人：     @author huhe    
 * 创建时间: 2019年10月16日/下午1:42:11
 * 项目名称：  valuation-manage
 * 文件名称: ValFundCharacterService.java
 * 文件描述: @Description: 估值产品性质服务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfbp.val.manage.service;


import java.util.List;

import com.win.dfbp.val.manage.entity.ValFundCharacter;

/**   
 * 包名称： com.win.dfbp.val.manage.service 
 * 类名称：ValFundCharacterService 
 * 类描述：估值产品性质服务类
 * 创建人：@author huhe 
 * 创建时间：2019年10月16日/下午1:42:11
 *     
 */
public interface ValFundCharacterService {
	
	/**
	 * 
	 * @Title: getValFundCharacterList
	 * @Description: 查询所有估值产品性质
	 * @return   
	 * @return: List<ValFundCharacter>   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年10月17日/上午11:28:07
	 */
	List<ValFundCharacter> getValFundCharacterList();
}
