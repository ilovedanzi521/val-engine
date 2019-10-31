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

package com.win.dfbp.val.engine.init;

import com.win.dfbp.val.engine.flink.FlinkFileReadTask;
import com.win.dfbp.val.engine.flink.FlinkKafKaConsumerTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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
    private FlinkFileReadTask flinkFileReadTask;

    @Override
    public void run(String... args){
        consumerTask.run();
    }
}
