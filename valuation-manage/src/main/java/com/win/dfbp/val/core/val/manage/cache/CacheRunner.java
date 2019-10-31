/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/15/14:30
 * 项目名称: dfbp-val-engine
 * 文件名称: CacheRunner.java
 * 文件描述: @Description: 缓存加载
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.core.val.manage.cache;

import com.win.dfas.common.service.IRedisCacheService;
import com.win.dfas.common.vo.SysRedisCacheReqVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.val.manage.cache
 * 类名称：CacheRunner
 * 类描述：缓存加载
 * 创建人：@author wanglei
 * 创建时间：2019/10/15/14:30
 */
@Component
@Slf4j
public class CacheRunner implements CommandLineRunner {
    @Autowired
    private IRedisCacheService redisCacheService;
    @Override
    public void run(String... args) throws Exception {
        log.info("run start");
        // 加载全量缓存
        redisCacheService.loadCache(new SysRedisCacheReqVO());
    }

}
