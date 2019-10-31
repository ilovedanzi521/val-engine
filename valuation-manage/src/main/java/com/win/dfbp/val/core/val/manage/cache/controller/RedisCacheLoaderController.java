/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-24/14:34
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisCacheLoaderController.java
 * 文件描述: @Description: 缓存controller
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.core.val.manage.cache.controller;

import com.win.dfas.common.vo.SysRedisCacheReqVO;
import com.win.dfas.common.vo.WinResponseData;
import com.win.dfbp.val.core.val.manage.cache.service.impl.RedisCacheLoaderImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.win.dfbp.val.manage.cache.controller
 * 类名称：RedisCacheLoaderController
 * 类描述：缓存controller
 * 创建人：@author zoujian
 * 创建时间：2019-10-24/14:34
 */
@RestController
@Api(value = "缓存controller", tags = {"缓存接口"})
@RequestMapping("/api/redisCache")
public class RedisCacheLoaderController {
    @Autowired
    RedisCacheLoaderImpl redisCacheLoader;

    @ApiOperation(value = "缓存刷新")
    @PostMapping("/refreshCache")
    WinResponseData refreshCache(SysRedisCacheReqVO sysRedisCacheReqVO){
        redisCacheLoader.refreshCache(sysRedisCacheReqVO);
        return  WinResponseData.handleSuccess("缓存刷新成功{}" ,sysRedisCacheReqVO);
    }
}
