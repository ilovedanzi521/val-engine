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

import com.win.dfbp.engine.service.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
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

        KafkaProducer kafkaProducer = context.getBean(KafkaProducer.class);
        for (int i = 0; i < 3; i++) {
            kafkaProducer.send("watchval","{\n" +
                    "  \"fund_no\": \"GHP01\",\n" +
                    "  \"fund_character\": \"001\",\n" +
                    "  \"portf_no\": \"123456\",\n" +
                    "  \"security_code\": \"337001\",\n" +
                    "  \"market_code\": \"SH\",\n" +
                    "  \"platform_code\": \"123\",\n" +
                    "  \"security_character\": \"123\",\n" +
                    "  \"invest_flag\": \"1\",\n" +
                    "  \"cash_settle_balance\": \"1222\",\n" +
                    "  \"stock_settle_amount\": \"456612\",\n" +
                    "  \"trade_direction\": \"1\"\n" +
                    "}");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        for (int i = 0; i < 3; i++) {
//            //调用消息发送类中的消息发送方法
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
