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

import com.alibaba.fastjson.JSONObject;
import com.win.dfbp.engine.dao.ValPositionMapper;
import com.win.dfbp.engine.util.SpringContextUtil;
import com.win.dfbp.entity.SecurityIndex;
import feign.Client;
import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：ApiSinkFunction
 * 类描述：api调用交易系统接口
 * 创建人：@author wanglei
 * 创建时间：2019/10/30/10:44
 */
@Slf4j
public class ApiSinkFunction  extends RichSinkFunction<SecurityIndex> {

    private String url;

    public ApiSinkFunction(String apiUrl) {
        this.url =apiUrl;
    }

    @Override
    public void invoke(SecurityIndex securityIndex, Context context){
        try {
            ApiProvide apiProvide= Feign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(ApiProvide.class, url);
            List<SecurityIndex> list = new ArrayList<>();
            list.add(securityIndex);
            Object object = apiProvide.put(list);
            log.info("Data write Api Server Success!Return:{}",object);
        }catch (Throwable e){
            log.error("api异常{}",e);
        }
    }
    interface ApiProvide {
        @RequestLine("PUT")
        @Headers("Content-Type: application/json")
        Object put(Object params);
    }
}

