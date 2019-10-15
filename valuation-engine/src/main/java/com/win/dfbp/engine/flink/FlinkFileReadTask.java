/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/12/13:35
 * 项目名称: dfbp-val-engine
 * 文件名称: FlinkKafKaConsumerTask.java
 * 文件描述: @Description: flink使用kafka消费消息的task任务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink;

import com.win.dfbp.engine.service.impl.MarketDataServiceImpl;
import com.win.dfbp.entity.ValMarket;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 包名称：com.win.dfbp.engine.flink
 * 类名称：FlinkKafKaConsumerTask
 * 类描述：flink使用kafka消费消息的task任务
 * 创建人：@author wanglei
 * 创建时间：2019/10/12/13:35
 */
@Component
public class FlinkFileReadTask {
    @Autowired
    private MarketDataServiceImpl marketDataService;

    @Async(value = "flinkFileReadThread")
    public void run() {
        // 1、解析文件读取到List集合中
        // 2、将List集合数据塞入Flink中
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        List<ValMarket> list = marketDataService.getValMarketData();
        try {
            DataSource<ValMarket> dataSource = env.fromCollection(list);
            dataSource.flatMap(new FlatMapFunction() {
                @Override
                public void flatMap(Object o, Collector collector) throws Exception {
                    return;
                }
            });
            dataSource.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
