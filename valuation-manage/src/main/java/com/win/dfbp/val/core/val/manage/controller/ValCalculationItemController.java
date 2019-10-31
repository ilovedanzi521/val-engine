/****************************************************
 * 创建人: @author huhe
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValCalculationItemController.java
 * 文件描述: @Description: 估值计算controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.core.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.core.val.manage.service.ValCalculationItemService;
import com.win.dfbp.val.core.val.manage.vo.query.ValCalculationItemQueryVO;

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
 * 类名称：ValCalculationItemController
 * 类描述：估值计算controller
 * 创建人：@author huhe
 * 创建时间：2019-10-16/17:41
 */
@RestController
@RequestMapping("/valCal")
@Api(value = "估值计算controller", tags = {"估值计算接口"})
public class ValCalculationItemController {
    @Autowired
    private ValCalculationItemService valCalculationItemService;

    @ApiOperation(value = "估值计算分页列表")
    @ApiImplicitParam(name = "reqVO", value = "估值计算查询参数", required = true, dataType = "ValCalculationItemQueryVO")
    @PostMapping("/item/list")
 	public WinResponseData getValCalculationItems(@RequestBody ValCalculationItemQueryVO reqVO) {
 		return WinResponseData.handleSuccess(valCalculationItemService.getValCalculationItems(reqVO));
 	}
}
