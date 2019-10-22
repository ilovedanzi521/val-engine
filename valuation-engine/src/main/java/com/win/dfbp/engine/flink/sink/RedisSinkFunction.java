/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/22/9:27
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisSinkFunction.java
 * 文件描述: @Description: 结果写入redis缓存
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.sink;

import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.engine.util.SpringContextUtil;
import com.win.dfbp.entity.SecurityIndex;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：RedisSinkFunction
 * 类描述：结果写入redis缓存
 * 创建人：@author wanglei
 * 创建时间：2019/10/22/9:27
 */
@Slf4j
public class RedisSinkFunction extends RichSinkFunction<SecurityIndex> {

    @Override
    public void invoke(SecurityIndex value, Context context) throws Exception {
        log.info("sink to VAL_POSITION");
        RedisUtil.set(RedisKeyPrefix.VAL_POSITION, value, -1);
    }
}

