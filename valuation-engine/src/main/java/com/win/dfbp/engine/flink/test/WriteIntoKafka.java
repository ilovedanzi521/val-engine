/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/12/13:18
 * 项目名称: dfbp-val-engine
 * 文件名称: WriteIntoKafka.java
 * 文件描述: @Description: 1
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.test;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.HashMap;
import java.util.Map;

/**
 * 包名称：com.win.dfbp.engine.flink.test
 * 类名称：WriteIntoKafka
 * 类描述：1
 * 创建人：@author wanglei
 * 创建时间：2019/10/12/13:18
 */
public class WriteIntoKafka {
    public static void main(String[] args) throws Exception {
        // create execution environment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Map properties= new HashMap();
        properties.put("bootstrap.servers", "192.168.0.61:9092");
        properties.put("topic", "watchval");

        // parse user parameters
        ParameterTool parameterTool = ParameterTool.fromMap(properties);

        // add a simple source which is writing some strings
        DataStream<String> messageStream = env.addSource(new SimpleStringGenerator());

        // write stream to Kafka
        messageStream.addSink(new FlinkKafkaProducer<>(parameterTool.getRequired("bootstrap.servers"),
                parameterTool.getRequired("topic"),
                new SimpleStringSchema()));

        messageStream.rebalance().map(new MapFunction<String, String>() {
            //序列化设置
            private static final long serialVersionUID = 1L;

            @Override
            public String map(String value) throws Exception {
                return value;
            }
        });

        messageStream.print();

        env.execute();
    }

    public static class SimpleStringGenerator implements SourceFunction<String> {
        //序列化设置
        private static final long serialVersionUID = 1L;
        boolean running = true;

        @Override
        public void run(SourceContext<String> ctx) throws Exception {
//            while(running) {
                ctx.collect(prouderJson());
//            }
        }

        private String prouderJson() {
            return "{\n" +
                    "  \"fundNo\": \"GHP01\",\n" +
                    "  \"fundCharacter\": \"001\",\n" +
                    "  \"portfNo\": \"123456\",\n" +
                    "  \"securityCode\": \"6005702\",\n" +
                    "  \"marketCode\": \"SH\",\n" +
                    "  \"platformCode\": \"123\",\n" +
                    "  \"securityCharacter\": \"bond\",\n" +
                    "  \"investFlag\": \"J\",\n" +
                    "  \"cashSettleBalance\": \"1222\",\n" +
                    "  \"stockSettleAmount\": \"456612\",\n" +
                    "  \"tradeDirection\": \"1\"\n" +
                    "}";
        }

        @Override
        public void cancel() {
            running = false;
        }
    }
}

