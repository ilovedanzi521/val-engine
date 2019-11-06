/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/11/6/10:49
 * 项目名称: dfbp-val-engine
 * 文件名称: InitBusinessRunner.java
 * 文件描述: @Description: 启动定时任务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.quartz;

import com.win.dfbp.val.manage.quartz.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 包名称：com.win.dfbp.val.manage.quartz
 * 类名称：InitBusinessRunner
 * 类描述：启动定时任务
 * 创建人：@author wanglei
 * 创建时间：2019/11/6/10:49
 */
@Component
public class InitBusinessRunner implements CommandLineRunner{
    @Autowired
    private QuartzService quartzService;
    @Override
    public void run(String... args) throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        //新增定时任务 1
        map.put("name","initBusinessJob");
        quartzService.deleteJob("initBusinessJob", "init");
        quartzService.addJob(InitBusinessJob.class, "initBusinessJob", "init", "0 * * * * ?", map);


    }
}
