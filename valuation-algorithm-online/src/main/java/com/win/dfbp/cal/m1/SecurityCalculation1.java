/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/14/11:44
 * 项目名称: dfbp-val-engine
 * 文件名称: SecurityCalculation1.java
 * 文件描述: @Description: 计算模块
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.m1;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.exception.WinException;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfas.common.util.SpringContextUtil;
import com.win.dfbp.cal.ISecurityCalculation;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.strategy.BaseStrategy;
import com.win.dfbp.strategy.StrategyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 包名称：com.win.dfbp.cal.m1
 * 类名称：SecurityCalculation1
 * 类描述：计算模块
 * 创建人：@author wanglei
 * 创建时间：2019/10/14/11:44
 */
@Slf4j
public class SecurityCalculation1 implements ISecurityCalculation {
    //判断计算模型
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        return true;
    }
    @Override
    public SecurityIndex calculateSecurityIndex(SecurityIndex securityIndex,SecurityIndex oldIndex) {
        SecurityParam securityParam = querySecurityBasciInfo(securityIndex.getSecurityCode());
        if(ObjectUtil.isEmpty(securityParam)){
            return securityIndex;
        }
        BaseStrategy strategy = judgeStrategy(securityIndex,securityParam);
        strategy.setSecurityIndex(securityIndex);
        strategy.calPositionIndex(oldIndex,securityParam);
        return securityIndex;
    }

    @Override
    public SecurityIndex initSecurityIndex(SecurityIndex securityIndex) {
        SecurityParam securityParam = querySecurityBasciInfo(securityIndex.getSecurityCode());
        if(ObjectUtil.isEmpty(securityParam)){
            return securityIndex;
        }
        BaseStrategy strategy = judgeStrategy(securityIndex,securityParam);
        strategy.setSecurityIndex(securityIndex);
        strategy.calInitIndex(securityParam);
        return securityIndex;
    }
    /**
     * @Title: judgeStrategy
     * @Description 获取BaseStrategy
     * @param securityIndex
     * @param securityParam
     * @return com.win.dfbp.strategy.BaseStrategy
     * @throws
     * @author wanglei
     * @Date 2019/10/18/16:54
     */
    private BaseStrategy judgeStrategy(SecurityIndex securityIndex,SecurityParam securityParam){
        StrategyFactory strategyFactory = SpringContextUtil.getBean(StrategyFactory.class);
        BaseStrategy strategy = strategyFactory.getPromotionStrategy(securityParam.getAssetType());
        return strategy;
    }

    /**
     * @Title: querySecurityBasciInfo
     * @Description 判断证券信息
     * @param securityCode
     * @return com.win.dfbp.entity.SecurityParam
     * @throws
     * @author wanglei
     * @Date 2019/10/18/10:45
     */
    public SecurityParam querySecurityBasciInfo(String securityCode) {
        //缓存中获取证券信息
        Object securityInfo = RedisUtil.get(RedisKeyPrefix.VAL_SECURITY_INFO+ CommonConstants.HORIZONTAL_LINE+securityCode);
        SecurityParam securityParam = null;
        if(ObjectUtil.isEmpty(securityInfo)){
           log.error("无法获取证券信息缓存,key={}",RedisKeyPrefix.VAL_SECURITY_INFO+ CommonConstants.HORIZONTAL_LINE+securityCode);
        }else{
            //1 . json转object 获取证券内码对用的证券基础信息
            securityParam = JSON.parseObject(JSON.toJSONString(securityInfo),SecurityParam.class);
        }
        return securityParam.setSecurityParam();
    }
}
