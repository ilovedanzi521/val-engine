/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/11:49
 * 项目名称: dfbp-val-engine
 * 文件名称: SecurityCalculationUtil.java
 * 文件描述: @Description: 证券计算util
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfas.common.util.SpringContextUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.entity.ValParamScheme;
import com.win.dfbp.strategy.BaseStrategy;
import com.win.dfbp.strategy.StrategyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 包名称：com.win.dfbp.engine.util
 * 类名称：SecurityCalculationUtil
 * 类描述：证券计算util
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/11:49
 */
@Slf4j
public class SecurityCalculationUtil {
    /**
     * @Title: calculateSecurityIndex
     * @Description 存在历史持仓计算
     * @param securityIndex
     * @param oldIndex
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/24/11:50
     */
    public static SecurityIndex calculateSecurityIndex(SecurityIndex securityIndex, SecurityIndex oldIndex) {
        SecurityParam securityParam = querySecurityBasciInfo(securityIndex.getFundNo(), securityIndex.getSecurityCode());
        if (ObjectUtil.isEmpty(securityParam)) {
            return securityIndex;
        }
        BaseStrategy strategy = judgeStrategy(securityIndex, securityParam);
        strategy.setSecurityIndex(securityIndex);
        strategy.calPositionIndex(oldIndex, securityParam);
        return securityIndex;
    }
    /**
     * @Title: initSecurityIndex
     * @Description 不存在历史持仓计算
     * @param securityIndex
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/24/11:50
     */
    public static SecurityIndex initSecurityIndex(SecurityIndex securityIndex) {
        //1获取产品方案信息
        String fundNo = securityIndex.getFundNo();
        Object scheme = RedisUtil.get(RedisKeyPrefix.FUND_VAL_SCHEME+CommonConstants.HORIZONTAL_LINE+fundNo);
        if(ObjectUtil.isEmpty(scheme)){
            log.error("无法获取估值参数方案信息:{}",fundNo);
            return securityIndex;
        }
        ValParamScheme valParamScheme = JSON.parseObject(JSON.toJSONString(scheme),ValParamScheme.class);
        //2获取证券进出信息，以及获取参数信息
        SecurityParam securityParam = querySecurityBasciInfo(valParamScheme.getValSchemeCode(), securityIndex.getSecurityCode());
        if (ObjectUtil.isEmpty(securityParam)) {
            return securityIndex;
        }
        securityParam.setFundNo(fundNo);
        //计算指标
        BaseStrategy strategy = judgeStrategy(securityIndex, securityParam);
        strategy.setSecurityIndex(securityIndex);
        strategy.calInitIndex(securityParam);
        return securityIndex;
    }

    /**
     * @Title: judgeStrategy
     * @Description
     * @param securityIndex
     * @param securityParam
     * @return com.win.dfbp.strategy.BaseStrategy
     * @throws
     * @author wanglei
     * @Date 2019/10/24/11:51
     */
    private static BaseStrategy judgeStrategy(SecurityIndex securityIndex, SecurityParam securityParam) {
        StrategyFactory strategyFactory = SpringContextUtil.getBean(StrategyFactory.class);
        BaseStrategy strategy = strategyFactory.getPromotionStrategy(securityParam.getAssetType());
        return strategy;
    }

   /**
    * @Title: querySecurityBasciInfo
    * @Description 获取证券信息
    * @param valSchemeCode 方案
    * @param securityCode 证券类型
    * @return com.win.dfbp.entity.SecurityParam
    * @throws
    * @author wanglei
    * @Date 2019/10/24/11:51
    */
    public static SecurityParam querySecurityBasciInfo(String valSchemeCode, String securityCode) {
        //缓存中获取证券信息
        Object securityInfo = RedisUtil.get(RedisKeyPrefix.VAL_SECURITY_INFO + CommonConstants.HORIZONTAL_LINE + securityCode);
        SecurityParam securityParam = null;
        if (ObjectUtil.isEmpty(securityInfo)) {
            log.error("无法获取证券信息缓存,key={}", RedisKeyPrefix.VAL_SECURITY_INFO + CommonConstants.HORIZONTAL_LINE + securityCode);
        } else {
            //1 . json转object 获取证券内码对用的证券基础信息
            securityParam = JSON.parseObject(JSON.toJSONString(securityInfo), SecurityParam.class);
        }
        return securityParam.setSecurityParam(valSchemeCode);
    }
}