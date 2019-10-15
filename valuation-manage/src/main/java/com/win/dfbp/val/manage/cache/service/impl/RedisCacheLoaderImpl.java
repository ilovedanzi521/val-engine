/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/15/14:32
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisCacheLoader.java
 * 文件描述: @Description: redis加载缓存
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.cache.service.impl;

import com.win.dfas.common.service.IRedisCacheService;
import com.win.dfas.common.vo.SysRedisCacheReqVO;

/**
 * 包名称：com.win.dfbp.val.manage.cache.service.impl
 * 类名称：RedisCacheLoader
 * 类描述：redis加载缓存
 * 创建人：@author wanglei
 * 创建时间：2019/10/15/14:32
 */
/****************************************************
 * 创建人：     @author hechengcheng
 * 创建时间: 2019年7月31日/上午10:03:31
 * 项目名称：  dfbp-common-basicparameter
 * 文件名称: BasicParmameterCacheImpl.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.win.dfbp.val.manage.cache.dao.ValRedisCacheMapper;
import com.win.dfbp.val.manage.enumeration.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.entity.SysRedisCache;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfas.common.util.WinCollectionUtil;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 包名称： com.win.dfbp.basicparameter.service.impl
 * 类名称：BasicParmameterCacheImpl
 * 类描述：TODO
 * 创建人：@author hechengcheng
 * 创建时间：2019年7月31日/上午10:03:31
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RedisCacheLoaderImpl implements IRedisCacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheLoaderImpl.class);

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private ValRedisCacheMapper valRedisCacheMapper;

    @Override
    public void loadCache(SysRedisCacheReqVO reqVO) {

        LOGGER.info("loadCache, start ...");

        // 开始时间
        Long startMillis = System.currentTimeMillis();

        // 获取缓存定义数据
        List<SysRedisCache> cacheList = valRedisCacheMapper.list(reqVO);

        LOGGER.info("loadCache, cacheList size is {} ...", cacheList.size());

        // 加载缓存
        this.loadCacheList(cacheList);

        LOGGER.info("loadCache, end, costTime is {} ...", (System.currentTimeMillis() - startMillis));
    }

    @Override
    public void refreshCache(SysRedisCacheReqVO reqVO) {

        LOGGER.info("refreshCache, start ...");

        // 开始时间
        Long startMillis = System.currentTimeMillis();

        // 获取缓存定义数据
        List<SysRedisCache> cacheList = valRedisCacheMapper.list(reqVO);

        LOGGER.info("refreshCache, cacheList size is {} ...", cacheList.size());

        // 清空缓存列表
        this.clearCacheList(cacheList);

        // 加载缓存列表
        this.loadCacheList(cacheList);

        LOGGER.info("refreshCache, end, costTime is {} ...", (System.currentTimeMillis() - startMillis));
    }

    @Override
    public void clearCache(SysRedisCacheReqVO reqVO) {

        LOGGER.info("clearCache, start ...");

        // 开始时间
        Long startMillis = System.currentTimeMillis();

        // 获取缓存定义数据
        List<SysRedisCache> cacheList = valRedisCacheMapper.list(reqVO);

        LOGGER.info("clearCache, cacheList size is {} ...", cacheList.size());

        // 清空缓存
        this.clearCacheList(cacheList);

        LOGGER.info("clearCache, end, costTime is {} ...", (System.currentTimeMillis() - startMillis));
    }

    /**
     * 加载缓存列表
     *
     * @param cacheList
     * @throws
     * @Title: loadCacheList
     * @return: void
     * @author: hechengcheng
     * @Date: 2019年7月31日/下午5:09:26
     */
    private void loadCacheList(List<SysRedisCache> cacheList) {

        if (CollectionUtil.isEmpty(cacheList)) {
            return;
        }

        CountDownLatch latch = new CountDownLatch(cacheList.size());

        Long startMillis = System.currentTimeMillis();

        for (SysRedisCache cache : cacheList) {

            // 获取缓存SQL
            String cacheSql = cache.getCacheSql();

            if (StrUtil.isEmpty(cacheSql)) {
                latch.countDown();
                continue;
            }

            // 规定线程池执行
            taskExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        LOGGER.info("loadCache, start cache {} ...", cache.getCacheType());

                        List<Map<String, Object>> list = valRedisCacheMapper.loadDataByCacheSql(cacheSql);

                        LOGGER.info("loadCache, cache, {}, list size is {} ...", cache.getCacheType(), list.size());

                        if (CollectionUtil.isEmpty(list)) {
                            return;
                        }

                        // List转Map
                        Map<String, Object> resultMap = WinCollectionUtil.list2map(list, cache.getCacheKeyField(), cache.getCacheType() + CommonConstants.HORIZONTAL_LINE);

                        if (CollectionUtil.isEmpty(resultMap)) {
                            return;
                        }

                        // 加入REDIS缓存(0-表示不失效)
                        RedisUtil.setByPipelined(resultMap, 0);
                        LOGGER.info("loadCache, cache success {}, cost time {} millisecond ...", cache.getCacheType(), (System.currentTimeMillis() - startMillis));

                        // redis缓存信息成功
                        cache.setCacheResult(StatusEnum.CacheStatusEnum.CACHE_STATUS_SUCCESS.getStatus());
                        cache.setCacheRow(list.size());

                    } catch (Exception e) {

                        // 设置缓存结果为失败
                        cache.setCacheResult(StatusEnum.CacheStatusEnum.CACHE_STATUS_FAILED.getStatus());
                        cache.setCacheRow(0);
                        LOGGER.error("loadCache, cache failed {}, cost time {} millisecond ... , reason {}", cache.getCacheType(), (System.currentTimeMillis() - startMillis), ExceptionUtil.stacktraceToString(e));

                    } finally {
                        // 更新REDIS缓存信息表
                        updateSysRedisCache(cache, startMillis);

                        latch.countDown();
                    }
                }
            });
        }

        // 判断是否全部执行完成
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 清空缓存列表
     *
     * @param cacheList
     * @throws
     * @Title: clearCacheList
     * @return: void
     * @author: hechengcheng
     * @Date: 2019年7月31日/下午5:03:58
     */
    private void clearCacheList(List<SysRedisCache> cacheList) {

        if (CollectionUtil.isEmpty(cacheList)) {
            return;
        }

        CountDownLatch latch = new CountDownLatch(cacheList.size());

        // 开始时间
        Long startMillis = System.currentTimeMillis();

        // 加载缓存列表
        for (SysRedisCache cache : cacheList) {

            if (StrUtil.isEmpty(cache.getCacheType())) {

                latch.countDown();
                continue;
            }

            // 规定线程池执行
            taskExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        LOGGER.info("clearCache, start cache {} ...", cache.getCacheType());

                        // 加入REDIS缓存(0-表示不失效)
                        RedisUtil.delByPrefix(cache.getCacheType());

                        LOGGER.info("clearCache, cache success {}, cost time {} millisecond ...", cache.getCacheType(), (System.currentTimeMillis() - startMillis));
                    } catch (Exception e) {
                        LOGGER.info("clearCache, cache failed {}, cost time {} millisecond ...", cache.getCacheType(), (System.currentTimeMillis() - startMillis));
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }

        // 判断是否全部执行完成
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 更新数据库信息
     * @Title: updateSysRedisCache
     * @param cache
     * @param startMillis
     * @return: void
     * @throws
     * @author: hechengcheng
     * @Date:  2019年9月18日/下午1:47:41
     */
    private void updateSysRedisCache(SysRedisCache cache ,long startMillis) {

        // 设置缓存时间
        cache.setCacheTime(DateUtil.now());

        // 设置缓存耗时（毫秒）
        cache.setCacheCostTime(System.currentTimeMillis() - startMillis);

        valRedisCacheMapper.update(cache);
    }

}

