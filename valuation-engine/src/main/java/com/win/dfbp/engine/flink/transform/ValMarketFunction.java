/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-15/16:03
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValMarketFunction.java
 * 文件描述: @Description: 行情触发计算指标状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.engine.flink.transform;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.engine.util.SpringContextUtil;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.entity.ValMarket;
import com.win.dfbp.strategy.BaseMarketStrategy;
import com.win.dfbp.strategy.MarketStrategyFactory;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.util.Collector;

import java.util.Map;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：ValMarketFunction
 * 类描述：行情触发计算指标状态
 * 创建人：@author zoujian
 * 创建时间：2019-10-15/16:03
 */
public class ValMarketFunction implements FlatMapFunction<ValMarket,Collector> {
    /**
     * 统计状态
     **/
    private transient ValueState<Map<String, Object>> indexState;

    /**
     * 行情数据触发 计算指标
     * @Title: flatMap
     * @param valMarket
     * @param collector
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-15/16:09
     */
    @Override
    public void flatMap(ValMarket valMarket, Collector collector) throws Exception {
        String key = valMarket.getSecurityCode();
        // 1、匹配证券基础信息
        Object securityObj  = RedisUtil.get(RedisKeyPrefix.VAL_SECURITY_INFO + CommonConstants.HORIZONTAL_LINE +  key);
        if(securityObj != null){
            SecurityParam securityParam = JSON.parseObject(JSON.toJSONString(securityObj),SecurityParam.class);
            // 2、按资产类别进行区分
            String assetType = securityParam.getAssetType();
            MarketStrategyFactory marketStrategyFactory = SpringContextUtil.getBean(MarketStrategyFactory.class);
            BaseMarketStrategy strategy = marketStrategyFactory.getPromotionStrategy(assetType);
            // 计算持仓指标
            strategy.calPositionIndex(valMarket, securityParam);
            collector.collect(securityParam);
        }
    }
}
