/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-24/14:48
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisCacheLoaderFeign.java
 * 文件描述: @Description: 缓存Feign接口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.engine.service.depand;

import com.win.dfas.common.vo.SysRedisCacheReqVO;
import com.win.dfas.common.vo.WinResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 包名称：com.win.dfbp.engine.service.depand
 * 类名称：RedisCacheLoaderFeign
 * 类描述：缓存Feign接口
 * 创建人：@author zoujian
 * 创建时间：2019-10-24/14:48
 */
@FeignClient(value = "dfbp-val-manage", fallbackFactory = RedisCacheLoaderFeignHystrix.class, url = "http://192.168.5.138:11030")
public interface RedisCacheLoaderFeign {

    /**
     * 缓存刷新
     * @Title: refreshCache
     * @param reqVO
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-24/14:53
     */
    @PostMapping("/api/redisCache/refreshCache")
    WinResponseData refreshCache(SysRedisCacheReqVO reqVO);
}
