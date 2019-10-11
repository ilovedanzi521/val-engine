/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/11/15:16
 * 项目名称: dfbp-val-engine
 * 文件名称: KafkaConsumer.java
 * 文件描述: @Description:
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 包名称：com.win.dfbp.engine.service
 * 类名称：KafkaConsumer
 * 类描述：
 * 创建人：@author wanglei
 * 创建时间：2019/10/11/15:16
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"${kafka.topic}"})
    public void listener(ConsumerRecord record) {
        Optional<?> msg = Optional.ofNullable(record.value());
        if (msg.isPresent()) {
            System.out.println(msg.get());
        }
    }
}
