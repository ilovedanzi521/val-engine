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

import com.alibaba.fastjson.JSON;
import com.win.dfbp.engine.flink.sink.ApiSinkFunction;
import com.win.dfbp.engine.flink.sink.MysqlSinkFunction;
import com.win.dfbp.engine.flink.sink.RedisSinkFunction;
import com.win.dfbp.engine.flink.transform.SecurityIndexFunction;
import com.win.dfbp.engine.service.impl.MarketDataServiceImpl;
import com.win.dfbp.engine.util.SpringContextUtil;
import com.win.dfbp.entity.SecurityIndex;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;
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
@Slf4j
@Component
public class FlinkKafKaConsumerTask {
    /**
     * 定义下单数据主键，通过主键计算指标
     */
//    private static String[] securityTranPrimaryKey = new String[]{
//            SecurityTranPrimaryKey.FUND_NO, SecurityTranPrimaryKey.PORTF_NO,
//            SecurityTranPrimaryKey.SECURITY_CODE,SecurityTranPrimaryKey.MARKET_CODE,
//            SecurityTranPrimaryKey.SECURITY_CHARACTER,SecurityTranPrimaryKey.INVEST_FLAG
//    };

    @Autowired
    private Properties kproperties;
    @Async(value = "kafkaConsumerThread")
    public void run() {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        FlinkKafkaConsumer consumer = new FlinkKafkaConsumer(
                kproperties.getProperty("topic"), new SimpleStringSchema(), kproperties);

        DataStream<String> messageStream = env.addSource(consumer);
        SingleOutputStreamOperator streamOperator= messageStream.flatMap((String line, Collector<SecurityIndex> out) -> {
           try{
               out.collect(JSON.parseObject(line,SecurityIndex.class));
           }catch (Exception e){
               log.error("消息报文:{},格式异常{}",line,e);
           }
        }).returns(SecurityIndex.class)
                // 按key分组，维护state时可认为只有一个key
                .keyBy(new KeySelector<SecurityIndex, String>() {
                    @Override
                    public String getKey(SecurityIndex securityIndex) throws Exception {
                        return securityIndex.key();
                    }
                })
                // 开始计算
                .flatMap(new SecurityIndexFunction()).setParallelism(1);
        streamOperator.addSink(new MysqlSinkFunction());
        streamOperator.addSink(new RedisSinkFunction());
        streamOperator.addSink(new ApiSinkFunction(kproperties.getProperty("apiUrl")));
        try {
            env.execute();
        } catch (Throwable e) {
            log.error("数据已经被消费:{}",e);
        }

    }
}
