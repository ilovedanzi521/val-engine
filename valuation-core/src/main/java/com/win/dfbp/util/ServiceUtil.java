/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/16:16
 * 项目名称: dfbp-val-engine
 * 文件名称: ServiceUtil.java
 * 文件描述: @Description: 业务相关工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.TradeDirectionConstant;
import com.win.dfbp.entity.SecurityParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 包名称：com.win.dfbp.util
 * 类名称：ServiceUtil
 * 类描述：业务相关工具类
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/16:16
 */
@Slf4j
public class ServiceUtil {
    /**
     * @Title: calCost
     * @Description 计算持仓数量
     * @param oldAmount
     * @param tradeAmount
     * @param tradeDirection
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/30/9:48
     */
   public static BigDecimal calAmount(BigDecimal oldAmount,BigDecimal tradeAmount,String tradeDirection){
       switch(tradeDirection){
           case TradeDirectionConstant.BUY:{
                return oldAmount.add(tradeAmount);
           }
           case TradeDirectionConstant.SELL:{
               return oldAmount.subtract(tradeAmount);
           }
           default:{
              return oldAmount.add(tradeAmount);
           }
       }
   }
}
