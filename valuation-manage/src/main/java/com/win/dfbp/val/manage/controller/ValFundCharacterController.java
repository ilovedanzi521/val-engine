/****************************************************
 * 创建人: @author huhe
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValFundCharacterController.java
 * 文件描述: @Description: 估值产品性质controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.manage.service.ValFundCharacterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.fa.manage.controller
 * 类名称：ValFundCharacterController
 * 类描述：估值产品性质controller
 * 创建人：@author huhe
 * 创建时间：2019-10-16/17:41
 */
@RestController
@RequestMapping("/fund/character")
@Api(value = "估值产品性质controller", tags = {"估值产品性质接口"})
public class ValFundCharacterController {
    @Autowired
    private ValFundCharacterService valFundCharacterService;

    @ApiOperation(value = "估值产品性质列表")
    @PostMapping("/list")
 	public WinResponseData getValCalculationItems() {
 		return WinResponseData.handleSuccess(valFundCharacterService.getValFundCharacterList());
 	}
}
