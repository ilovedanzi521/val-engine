/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/30/10:44
 * 项目名称: dfbp-val-engine
 * 文件名称: ApiSinkFunction.java
 * 文件描述: @Description: api调用交易系统接口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.sink;

import com.win.dfbp.engine.dao.ValPositionMapper;
import com.win.dfbp.engine.util.SpringContextUtil;
import com.win.dfbp.entity.SecurityIndex;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.springframework.stereotype.Service;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：ApiSinkFunction
 * 类描述：api调用交易系统接口
 * 创建人：@author wanglei
 * 创建时间：2019/10/30/10:44
 */
@Slf4j
public class ApiSinkFunction  extends RichSinkFunction<SecurityIndex> {
    @Override
    public void invoke(SecurityIndex securityIndex, Context context){
        try {

            ValPositionMapper valPositionMapper = SpringContextUtil.getBean(ValPositionMapper.class);
            valPositionMapper.insertValPosition(securityIndex);
            log.info("Data write mysql Success!");
        }catch (Throwable e){
            log.error("数据库异常{}",e);
        }
    }
}
