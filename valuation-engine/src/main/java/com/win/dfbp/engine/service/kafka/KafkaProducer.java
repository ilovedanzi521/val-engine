/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/11/15:15
 * 项目名称: dfbp-val-engine
 * 文件名称: KafkaConsumer.java
 * 文件描述: @Description: kafka消费者
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 包名称：com.win.dfbp.engine.service
 * 类名称：KafkaConsumer
 * 类描述：kafka生产者
 * 创建人：@author wanglei
 * 创建时间：2019/10/11/15:15
 */
@Component
@Slf4j
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public void send(String topic,String data) {
        log.info("kafka sendMessage start");
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("kafka sendMessage error, ex = {}, topic = {}, data = {}", ex, topic, data);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                log.info("kafka sendMessage success topic = {}, data = {}",topic, data);
            }
        });
        log.info("kafka sendMessage end");
    }
}
