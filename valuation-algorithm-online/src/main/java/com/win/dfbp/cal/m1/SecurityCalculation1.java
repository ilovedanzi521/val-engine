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

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.cal.ISecurityCalculation;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.strategy.BaseStrategy;
import com.win.dfbp.strategy.StrategyFactory;

/**
 * 包名称：com.win.dfbp.cal.m1
 * 类名称：SecurityCalculation1
 * 类描述：计算模块
 * 创建人：@author wanglei
 * 创建时间：2019/10/14/11:44
 */
public class SecurityCalculation1 implements ISecurityCalculation {
    //判断计算模型
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        return true;
    }

    @Override
    public SecurityIndex calculateSecurityIndex(SecurityIndex securityIndex,SecurityIndex oldIndex) {
        String securityCharacter = securityIndex.getSecurityCharacter();

        BaseStrategy strategy = new StrategyFactory().getPromotionStrategy(securityCharacter);
        strategy.setSecurityIndex(securityIndex);
        strategy.calPositionIndex(oldIndex);
        return securityIndex;
    }

    @Override
    public SecurityIndex initSecurityIndex(SecurityIndex securityIndex) {
        //获取证券性质

        String securityCharacter = securityIndex.getSecurityCharacter();
        BaseStrategy strategy = new StrategyFactory().getPromotionStrategy(securityCharacter);
        strategy.setSecurityIndex(securityIndex);
        strategy.calInitIndex();
        return securityIndex;
    }
}
