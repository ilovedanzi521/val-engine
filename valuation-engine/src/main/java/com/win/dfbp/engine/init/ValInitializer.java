/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/12/10:00
 * 项目名称: dfbp-val-engine
 * 文件名称: ValInitializer.java
 * 文件描述: @Description: flink计算入口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.init;

import com.win.dfbp.engine.flink.FlinkFileReadTask;
import com.win.dfbp.engine.flink.FlinkKafKaConsumerTask;
import com.win.dfbp.engine.flink.FlinkKafKaProducerTask;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 包名称：com.win.dfbp.engine.init
 * 类名称：ValInitializer
 * 类描述：flink计算入口
 * 创建人：@author wanglei
 * 创建时间：2019/10/12/10:00
 */
@Component
@Slf4j
public class ValInitializer implements CommandLineRunner {
    @Autowired
    private FlinkKafKaConsumerTask consumerTask;
    @Autowired
    private FlinkKafKaProducerTask producerTask;
    @Autowired
    private FlinkFileReadTask flinkFileReadTask;

    @Override
    public void run(String... args) throws Exception {
        flinkFileReadTask.run();
        consumerTask.run();
    }
}
