/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-19/16:00
 * 项目名称: dfbp-val-engine
 * 文件名称: DatasourceConfig.java
 * 文件描述: @Description: 数据库连接配置
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.engine.config;

import com.win.dfbp.engine.util.KafkaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 包名称：com.win.dfbp.engine.config
 * 类名称：DatasourceConfig
 * 类描述：数据库连接配置
 * 创建人：@author zoujian
 * 创建时间：2019-10-19/16:00
 */
@Component
@ConfigurationProperties("spring.datasource")
public class DatasourceConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String type;

    @Bean(name ="dataSourceProperties")
    private Properties dataSourceProperties(){
        Properties properties = new Properties();
        properties.setProperty("driverClassName", getDriverClassName());
        properties.setProperty("url", getUrl());
        properties.setProperty("username", getUsername());
        properties.setProperty("password", getPassword());
        properties.setProperty("type", getType());
        return properties;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
