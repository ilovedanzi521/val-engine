/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/16:16
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisServiceUtil.java
 * 文件描述: @Description: redis业务相关工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 包名称：com.win.dfbp.util
 * 类名称：RedisServiceUtil
 * 类描述：redis业务相关工具类
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/16:16
 */
@Slf4j
public class RedisServiceUtil {
    /**
     * @Title: getRedisJsonFieldValue
     * @Description 获取redis缓存中，json字符串中key对应的value
     * @param key
     * @param field
     * @return java.lang.String
     * @throws
     * @author wanglei
     * @Date 2019/10/16/16:19
     */
    public static String getRedisJsonFieldValue(String redisKeyPrefix, String key, String field) {
        Object fundValSchemeJson = RedisUtil.get(redisKeyPrefix+ CommonConstants.HORIZONTAL_LINE + key);
        if(ObjectUtil.isNotEmpty(fundValSchemeJson)){
            Object rtnObject = JSON.parseObject(JSON.toJSONString(fundValSchemeJson), Map.class).get(field);
            if(ObjectUtil.isEmpty(rtnObject)){
                log.error("估值参数缓存中,valCriteria is null！");
            }else{
                return (String) rtnObject;
            }
        }else{
            log.error("估值参数没有加载缓存！");
        }

        return null;
    }

}
