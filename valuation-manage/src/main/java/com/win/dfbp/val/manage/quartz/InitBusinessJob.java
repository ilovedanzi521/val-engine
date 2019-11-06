/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/11/6/10:44
 * 项目名称: dfbp-val-engine
 * 文件名称: InitBusinessJob.java
 * 文件描述: @Description: 业务初始化
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.manage.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 包名称：com.win.dfbp.val.manage.quartz
 * 类名称：InitBusinessJob
 * 类描述：业务初始化
 * 创建人：@author wanglei
 * 创建时间：2019/11/6/10:44
 */
@Slf4j
public class InitBusinessJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取参数
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        // 业务逻辑 ...


        log.info("------springbootquartzonejob执行" + jobDataMap.get("name").toString() + "###############" + jobExecutionContext.getTrigger());

    }
}
