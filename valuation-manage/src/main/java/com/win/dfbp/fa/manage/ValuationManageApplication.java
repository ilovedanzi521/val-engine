/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-9/15:40
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValuationManageApplication.java
 * 文件描述: @Description: 启动类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.fa.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 包名称：com.win.dfbp.fa.manage
 * 类名称：ValuationManageApplication
 * 类描述：启动类
 * 创建人：@author zoujian
 * 创建时间：2019-10-9/15:40
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.win.dfbp"})
@EnableTransactionManagement
public class ValuationManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValuationManageApplication.class, args);
    }
}
