/****************************************************
 * 创建人: @author huhe    
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValCalParamMethodConfigureController.java
 * 文件描述: @Description: 估值计算controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.manage.service.ValParamMethodConfigureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.fa.manage.controller
 * 类名称：ValCalParamMethodConfigureController
 * 类描述：参数方法配置controller
 * 创建人：@author huhe
 * 创建时间：2019-10-16/17:41
 */
@RestController
@RequestMapping("/param/configure")
@Api(value = "参数方法配置controller", tags = {"参数方法配置接口"})
public class ValCalParamMethodConfigureController {
    @Autowired
    private ValParamMethodConfigureService valParamMethodConfigureService;

    @ApiOperation(value = "参数方法配置分页列表")
    @PostMapping("/method")
 	public WinResponseData getValParamMethodByParam() {
 		return WinResponseData.handleSuccess(valParamMethodConfigureService.getMethodByParam());
 	}
    
    @ApiOperation(value = "估值参数方法列表")
    @PostMapping("/method/list")
 	public WinResponseData getValParamMethods() {
 		return WinResponseData.handleSuccess(valParamMethodConfigureService.getValParamMethods());
 	}
    
}
