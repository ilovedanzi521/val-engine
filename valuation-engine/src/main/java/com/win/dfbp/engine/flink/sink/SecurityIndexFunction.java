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

package com.win.dfbp.engine.flink.sink;

import com.win.dfbp.engine.flink.state.SecurityIndexState;
import com.win.dfbp.entity.SecurityIndex;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexFunction
 * 类描述：计算证券指标状态
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:39
 */
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
        // access the state in
        SecurityIndexState lastState = indexState.value();
        // 第一次进入计算,更新state,输入原样返回
        if (lastState == null) {
            // 初始化state
            lastState = lastState.clone(in);

            // 进来的数据原样返回
            out.collect(in);
            // 更新state
            indexState.update(lastState);
        } else {
            // count 累加
//            lastState
//
            //TODO 计算模块
            // 更新state
            indexState.update(lastState);
            //持仓信息,不持仓,按条件清理
            boolean hold = true;
            if(!hold){
                indexState.clear();
            }

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
}