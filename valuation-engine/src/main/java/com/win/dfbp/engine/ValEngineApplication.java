/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/11/9:50
 * 项目名称: dfbp-val-engine
 * 文件名称: ValEngineApplication.java
 * 文件描述: @Description: 启动类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine;

import com.win.dfbp.engine.service.kafka.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 包名称：com.win.dfbp.engine
 * 类名称：ValEngineApplication
 * 类描述：启动类
 * 创建人：@author wanglei
 * 创建时间：2019/10/11/9:50
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan({"com.win.*"})
@SpringBootApplication
public class ValEngineApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ValEngineApplication.class, args);
        //模拟测试
    }
}
