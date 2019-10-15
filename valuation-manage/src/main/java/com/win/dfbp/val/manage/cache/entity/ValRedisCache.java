/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/15/14:26
 * 项目名称: dfbp-val-engine
 * 文件名称: ValRedisCache.java
 * 文件描述: @Description: redisCache类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.cache.entity;

import com.win.dfas.common.entity.BaseEntity;
import lombok.Data;

/**
 * 包名称：com.win.dfbp.val.manage.cache.entity
 * 类名称：ValRedisCache
 * 类描述：redisCache类
 * 创建人：@author wanglei
 * 创建时间：2019/10/15/14:26
 */
@Data
public class ValRedisCache extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 缓存类型
     */
    private String cacheType;
    /**
     * 缓存名称描述
     */
    private String cacheName;

    /**
     * 缓存key字段, 该字段必须包含在cache_sql中
     */
    private String cacheKeyField;

    /**
     * 缓存SQL
     */
    private String cacheSql;

    /**
     * 缓存结果: 0-成功、1-失败
     */
    private Integer cacheResult;

    /**
     * 缓存时间
     */
    private String cacheTime;

    /**
     * 缓存条数
     */
    private Integer cacheRow;

    /**
     * 缓存耗时(毫秒)
     */
    private Long cacheCostTime;
}
