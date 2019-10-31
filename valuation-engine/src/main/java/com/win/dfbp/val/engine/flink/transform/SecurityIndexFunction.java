/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:39
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexFunction.java
 * 文件描述: @Description: 计算证券指标状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.engine.flink.transform;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.val.common.constant.RedisKeyPrefix;
import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityIndexCash;
import com.win.dfbp.val.engine.flink.state.SecurityIndexState;
import com.win.dfbp.val.engine.util.SecurityCalculationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexFunction
 * 类描述：计算证券指标状态
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:39
 */
@Slf4j
public class SecurityIndexFunction extends RichFlatMapFunction<SecurityIndex, SecurityIndex> {
    /**
     * 统计状态
     **/
    private transient ValueState<SecurityIndexState> indexState;
    /**
     * 有状态计算
     *
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    public void flatMap(SecurityIndex in, Collector<SecurityIndex> out) throws Exception {
        // 获取flink状态内存中的数据
        SecurityIndexState lastState = indexState.value();
        String algorithm = "";
        //获取数据库或redis缓存中是否存在持仓
        Object cashSecurityIndex = RedisUtil.get(RedisKeyPrefix.VAL_POSITION + CommonConstants.HORIZONTAL_LINE + in.key());
        // 第一次进入计算,更新state,init state
        if (lastState == null) {
            if (cashSecurityIndex == null) {
                try {
                    SecurityIndex stockList = SecurityCalculationUtil.initSecurityIndex(in);
                    // 初始化state
                    SecurityIndexState state = new SecurityIndexState();
                    //stockList
                    if (stockList.getIndexVO() != null) {
                        out.collect(stockList);
                        // 更新state
                        indexState.update(state.clone(stockList));
                    }
                } catch (Throwable throwable) {
                    log.error("计算有异常:{}", throwable);
                }
            } else {
                SecurityIndex oldIndex = JSON.parseObject(JSON.toJSONString(cashSecurityIndex), SecurityIndexCash.class).parseSecurityIndex();
                existHistoryPosition(in, oldIndex, out, lastState);
            }
        } else {
            SecurityIndex oldIndex = lastState.parse();
            if(cashSecurityIndex!=null){
                BigDecimal fairPrice = JSON.parseObject(JSON.toJSONString(cashSecurityIndex), SecurityIndexCash.class)
                        .getFairPrice();
                oldIndex.getIndexVO().setFairPrice(fairPrice);
            }
            existHistoryPosition(in, oldIndex, out, lastState);
            //非第一次进入，进行计算
        }
    }

    /**
     * 初始化ValueState(未指定默认值，官方推荐自己处理)
     *
     * @param config
     */
    @Override
    public void open(Configuration config) {
        ValueStateDescriptor<SecurityIndexState> descriptor =
                new ValueStateDescriptor<>(
                        // the state name
                        "indexVO",
                        // type information
                        TypeInformation.of(new TypeHint<SecurityIndexState>() {
                        }));
        indexState = getRuntimeContext().getState(descriptor);
    }


    /**
     * @Title: existHistoryPosition
     * @Description 存在历史持仓计算入口
     * @param in
     * @param oldIndex
     * @param out
     * @param lastState
     * @return void
     * @throws
     * @author wanglei
     * @Date 2019/10/24/8:43
     */
    private void existHistoryPosition(SecurityIndex in,SecurityIndex oldIndex,
                                      Collector<SecurityIndex> out, SecurityIndexState lastState) throws IOException {
        try {
            SecurityIndex stockList = SecurityCalculationUtil.calculateSecurityIndex(in, oldIndex);
            if (stockList != null) {
                if(lastState==null){
                    lastState = new SecurityIndexState();
                }
                lastState = lastState.clone(stockList);
            }
            if (stockList.getIndexVO() != null) {
                out.collect(stockList);
                indexState.update(lastState);
            }
            //持仓信息,不持仓,按条件清理
            boolean hold = true;
            if (!hold) {
                indexState.clear();
            }
        }catch (Throwable throwable){
            log.error("计算有异常:{}",throwable);
        }

    }
}
