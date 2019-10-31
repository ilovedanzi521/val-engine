/****************************************************
 * 创建人: @author huhe
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValMethodController.java
 * 文件描述: @Description: 估值方法controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.core.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.core.val.manage.service.ValMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.fa.manage.controller
 * 类名称：ValMethodController
 * 类描述：估值方法controller
 * 创建人：@author huhe
 * 创建时间：2019-10-16/17:41
 */
@RestController
@RequestMapping("/method")
@Api(value = "估值方法controller", tags = {"估值方法接口"})
public class ValMethodController {
    @Autowired
    private ValMethodService valMethodService;

    @ApiOperation(value = "估值方法列表")
    @PostMapping("/list")
 	public WinResponseData getValMethods() {
 		return WinResponseData.handleSuccess(valMethodService.getValMethodList());
 	}
}
