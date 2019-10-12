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

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 包名称：com.win.dfbp.engine.flink
 * 类名称：FlinkKafKaConsumerTask
 * 类描述：flink使用kafka消费消息的task任务
 * 创建人：@author wanglei
 * 创建时间：2019/10/12/13:35
 */
@Component
public class FlinkKafKaConsumerTask {
    @Autowired
    private Properties properties;
    @Async(value = "kafkaConsumerThread")
    public void run() {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        FlinkKafkaConsumer consumer = new FlinkKafkaConsumer(
                properties.getProperty("topic"), new SimpleStringSchema(), properties);
        DataStream<String> messageStream = env
                .addSource(consumer);
        messageStream.rebalance().map(new MapFunction<String, String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String map(String value) throws Exception {
                return value;
            }
        });
        messageStream.print();

        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
