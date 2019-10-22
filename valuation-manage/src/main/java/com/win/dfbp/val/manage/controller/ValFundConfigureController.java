/****************************************************
 * 创建人: @author huhe    
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValFundConfigureController.java
 * 文件描述: @Description: 估值计算controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.manage.service.ValFundConfigureService;
import com.win.dfbp.val.manage.vo.query.ValFundConfigureQueryVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.fa.manage.controller
 * 类名称：ValFundConfigureController
 * 类描述：估值计算controller
 * 创建人：@author huhe
 * 创建时间：2019-10-16/17:41
 */
@RestController
@RequestMapping("/fund/configure")
@Api(value = "方法估值配置controller", tags = {"方法估值配置接口"})
public class ValFundConfigureController {
    @Autowired
    private ValFundConfigureService valFundConfigureService;

    @ApiOperation(value = "方法估值配置分页列表")
    @ApiImplicitParam(name = "reqVO", value = "方法估值配置查询参数", required = true, dataType = "FundConfigureQueryVO")
    @PostMapping("/list")
 	public WinResponseData getFundConfigures(@RequestBody ValFundConfigureQueryVO reqVO) {
 		return WinResponseData.handleSuccess(valFundConfigureService.getValFundConfigures(reqVO));
 	}
    @ApiOperation(value = "查询全部方法估值配置列表")
    @PostMapping("/all")
 	public WinResponseData getFundAll() {
 		return WinResponseData.handleSuccess(valFundConfigureService.getValFundAll());
 	}
}
