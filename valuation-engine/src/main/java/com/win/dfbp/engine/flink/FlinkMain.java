/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/11/16:54
 * 项目名称: dfbp-val-engine
 * 文件名称: FlinkMain.java
 * 文件描述: @Description: flink入口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink;

import com.win.dfbp.engine.flink.sink.SecurityIndexFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 包名称：com.win.dfbp.engine.flink
 * 类名称：FlinkMain
 * 类描述：flink入口
 * 创建人：@author wanglei
 * 创建时间：2019/10/11/16:54
 */
public class FlinkMain {
    public void run() {
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
            Properties properties = new Properties();
            properties.setProperty("bootstrap.servers", "");
            properties.setProperty("group.id", "flink_consumer");

            DataStream<String> stream = env.addSource(new FlinkKafkaConsumer09<>(
                    "flink-demo", new SimpleStringSchema(), properties));

//            stream.rebalance().map(new SecurityIndexFunction());
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
