/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-24/14:53
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisCacheLoaderFeignHystrix.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.engine.service.depand;

import com.win.dfas.common.vo.SysRedisCacheReqVO;
import com.win.dfas.common.vo.WinResponseData;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.engine.service.depand
 * 类名称：RedisCacheLoaderFeignHystrix
 * 类描述：缓存Feign熔断处理
 * 创建人：@author zoujian
 * 创建时间：2019-10-24/14:53
 */
@Component
public class RedisCacheLoaderFeignHystrix implements FallbackFactory<RedisCacheLoaderFeign> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheLoaderFeignHystrix.class);

    @Override
    public RedisCacheLoaderFeign create(Throwable throwable) {
        return new RedisCacheLoaderFeign(){
            @Override
            public WinResponseData refreshCache(SysRedisCacheReqVO reqVO) {
                    return handHystrix(throwable);
            }
        };
    }

    /**
     * 熔断处理
     * @Title: handHystrix
     * @param throwable
     * @return: com.win.dfas.common.vo.WinResponseData
     * @throws
     * @author: lidongxing
     * @Date:  2019-10-12/09:48
     */
    private WinResponseData handHystrix(Throwable throwable) {
        LOGGER.error("服务不存在或网络断开,错误原因:{}", throwable.getMessage());
        return WinResponseData.handleError("服务不存在或网络断开,错误原因:{}", throwable.getMessage());
    }
}
