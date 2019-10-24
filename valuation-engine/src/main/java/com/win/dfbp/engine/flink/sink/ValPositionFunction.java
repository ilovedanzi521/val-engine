/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-19/17:14
 * 项目名称: dfbp-val-engine
 * 文件名称: ValPositionFunction.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.engine.flink.sink;

import com.win.dfbp.entity.SecurityParam;
import org.apache.flink.api.common.functions.MapFunction;
//import org.apache.flink.api.java.io.jdbc.JDBCOutputFormat;
import org.apache.flink.types.Row;
import org.apache.flink.util.Collector;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Properties;

import static java.sql.Types.DECIMAL;
import static java.sql.Types.VARCHAR;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：ValPositionFunction
 * 类描述：
 * 创建人：@author zoujian
 * 创建时间：2019-10-19/17:14
 */
public class ValPositionFunction implements MapFunction<Collector,SecurityParam> {

    @Autowired
    private Properties dataSourceProperties;
    @Override
    public SecurityParam map(Collector securityParam) throws Exception {
        String driverClassName = dataSourceProperties.getProperty("driverClassName");
        String url = dataSourceProperties.getProperty("url");
        String username = dataSourceProperties.getProperty("username");
        String password = dataSourceProperties.getProperty("password");
        String query = "update val_position set fair_price = ?,position_market_value = ?,floating_pl= ? where security_code = ? and market_code = ?";
        //  参数数据类型
        int[] sqlTypes = {DECIMAL,DECIMAL,DECIMAL,VARCHAR,VARCHAR};
//        JDBCOutputFormat jdbcOutputFormat = JDBCOutputFormat.buildJDBCOutputFormat()
//                .setDrivername(driverClassName)
//                .setDBUrl(url)
//                .setUsername(username)
//                .setPassword(password)
//                .setQuery(query)
//                .setSqlTypes(sqlTypes)
//                .finish();
//        Row rowComb = new Row(sqlTypes.length);
//        try {
//            jdbcOutputFormat.writeRecord(rowComb);
//            jdbcOutputFormat.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
