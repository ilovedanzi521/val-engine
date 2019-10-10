/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-9/17:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: MarketDataController.java
 * 文件描述: @Description: 行情数据controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.controller;

import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.manage.service.MarketDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.fa.manage.controller
 * 类名称：MarketDataController
 * 类描述：行情数据controller
 * 创建人：@author zoujian
 * 创建时间：2019-10-9/17:41
 */
@RestController
@RequestMapping("/marketData")
@Api(value = "行情数据controller", tags = {"行情数据接口"})
public class MarketDataController {
    @Autowired
    private MarketDataService marketDataService;

    @ApiOperation(value = "行情数据更新", notes = "行情数据更新")
    @PostMapping("/updateValMarket")
    public WinResponseData updateValMarket(){
        marketDataService.updateValMarket();
        return null;
    }
}
