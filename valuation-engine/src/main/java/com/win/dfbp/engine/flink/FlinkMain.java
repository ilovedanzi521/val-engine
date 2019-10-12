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
import com.win.dfbp.engine.util.SpringContextUtil;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
@Component
public class FlinkMain {
    @Async(value = "kafkaConsumerThread")
    public void run() {
        KafkaProperties kafkaProperties = SpringContextUtil.getBean(KafkaProperties.class);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", kafkaProperties.getBootstrapServers().get(0));
        properties.setProperty("group.id", kafkaProperties.getConsumer().getGroupId());

        DataStream<String> stream = env.addSource(new FlinkKafkaConsumer<>(
                "watchval", new SimpleStringSchema(), properties));
        stream.print();


//        stream.writeAsText( this.getClass().getResource("/").getPath());
//            stream.rebalance().flatMap(new SecurityIndexFunction());
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
