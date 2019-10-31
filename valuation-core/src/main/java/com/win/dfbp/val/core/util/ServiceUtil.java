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

package com.win.dfbp.val.core.util;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.val.common.constant.RedisKeyPrefix;
import com.win.dfbp.val.common.constant.TradeDirectionConstant;
import com.win.dfbp.val.core.entity.CalculationValClass;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    /**
     * @Title: queryFundClass
     * @Description 获取产品对应的指标
     * @param fundNo
     * @return java.util.List<com.win.dfbp.val.core.entity.CalculationValClass>
     * @throws
     * @author wanglei
     * @Date 2019/10/31/18:39
     */
   public static  List<CalculationValClass> queryFundClass(String fundNo){
       String pattern = RedisKeyPrefix.FUND_VAL_CLASS_CONFIG+ CommonConstants.HORIZONTAL_LINE+fundNo+"*";
       //获取指标list
       List<Object> list = RedisUtil.matchGet(pattern);
       //迭代计算
       List<CalculationValClass> calList = new ArrayList<>();
       for (Object object : list) {
           CalculationValClass calculationItem = JSON.parseObject(JSON.toJSONString(object),CalculationValClass.class);
           calList.add(calculationItem);
           //排序
           Collections.sort(calList);
       }
       return calList;
   }


}
