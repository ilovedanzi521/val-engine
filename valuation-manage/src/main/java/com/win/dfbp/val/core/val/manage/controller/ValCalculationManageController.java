/****************************************************
 * 创建人: @author huhe
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValCalculationManageController.java
 * 文件描述: @Description: 估值计算controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.core.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.core.val.manage.vo.query.ValCalculationManageQueryVO;
import com.win.dfbp.val.core.val.manage.service.ValCalculationManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.fa.manage.controller
 * 类名称：ValCalculationManageController
 * 类描述：估值计算controller
 * 创建人：@author huhe
 * 创建时间：2019-10-16/17:41
 */
@RestController
@RequestMapping("/valManage")
@Api(value = "估值方法管理controller", tags = {"估值方法管理接口"})
public class ValCalculationManageController {
    @Autowired
    private ValCalculationManageService valCalculationManageService;

    @ApiOperation(value = "估值方法管理分页列表")
    @ApiImplicitParam(name = "reqVO", value = "估值方法管理查询参数", required = true, dataType = "ValCalculationManageQueryVO")
    @PostMapping("/method/list")
 	public WinResponseData getValCalculationManages(@RequestBody ValCalculationManageQueryVO reqVO) {
 		return WinResponseData.handleSuccess(valCalculationManageService.getValCalculationManages(reqVO));
 	}

    @ApiOperation(value = "分类方法列表")
    @PostMapping("/class/methods")
 	public WinResponseData getMethodByClass() {
 		return WinResponseData.handleSuccess(valCalculationManageService.getMethodByClass());
 	}
}
