/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/25/13:45
 * 项目名称: dfbp-val-engine
 * 文件名称: MysqlSinkFunction.java
 * 文件描述: @Description: 持仓数据sink到mysql
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.engine.flink.sink;

import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.engine.dao.ValPositionMapper;
import com.win.dfbp.val.engine.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：MysqlSinkFunction
 * 类描述：持仓数据sink到mysql
 * 创建人：@author wanglei
 * 创建时间：2019/10/25/13:45
 */
@Slf4j
public class MysqlSinkFunction extends RichSinkFunction<SecurityIndex> {
    @Override
    public void invoke(SecurityIndex securityIndex, Context context){
        try {
            //mysql数据持久化
            ValPositionMapper valPositionMapper = SpringContextUtil.getBean(ValPositionMapper.class);
            valPositionMapper.insertValPosition(securityIndex);
            log.info("Data write mysql Success!");
        }catch (Throwable e){
            log.error("数据库异常{}",e);
        }
    }
}
