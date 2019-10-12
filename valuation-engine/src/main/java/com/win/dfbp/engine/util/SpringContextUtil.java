/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/12/9:25
 * 项目名称: dfbp-val-engine
 * 文件名称: ApplicationUtil.java
 * 文件描述: @Description: application util获取实例
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.engine.util
 * 类名称：ApplicationUtil
 * 类描述：application util获取实例
 * 创建人：@author wanglei
 * 创建时间：2019/10/12/9:25
 */

@Component("springContextUtils")
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        return (T) applicationContext.getBean(beanId);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return (T) applicationContext.getBean(requiredType);
    }

    /**
     * @Title: setApplicationContext
     * @Description 获取applicationContext
     * @param applicationContext
     * @return void
     * @throws BeansException
     * @author wanglei
     * @Date 2019/10/12/9:26
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
}
