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

/**
 * 包名称：com.win.dfbp.cal.m1
 * 类名称：SecurityCalculation1
 * 类描述：计算模块
 * 创建人：@author wanglei
 * 创建时间：2019/10/14/11:44
 */
public class SecurityCalculation1 implements ISecurityCalculation {
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        //todo
        return true;
    }

    @Override
    public SecurityIndex calculateSecurityIndex(SecurityIndex securityIndex,SecurityIndex oldIndex) {
        //todo
        SecurityIndexVO indexVO = new SecurityIndexVO();
        //内存获取
        indexVO.setCostPrice("110.00");
        indexVO.setFairPrice("110.00");
        indexVO.setFloatingPL("23.00");
        indexVO.setInterestRateOfHundred("0.79");
        indexVO.setPositionCost("110.00");
        indexVO.setPositionMarketValue("111.00");
        securityIndex.setIndexVO(indexVO);
        return securityIndex;
    }

    @Override
    public SecurityIndex initSecurityIndex(SecurityIndex securityIndex) {
        //todo
        securityIndex.getFundNo();
        //获取证券性质
        securityIndex.getSecurityCharacter();

        RedisUtil.get(RedisKeyPrefix.CommonConstants.HORIZONTAL_LINE);

        SecurityIndexVO indexVO = new SecurityIndexVO();
        //内存获取
        indexVO.setCostPrice("110.00");
        indexVO.setFairPrice("110.00");
        indexVO.setFloatingPL("23.00");
        indexVO.setInterestRateOfHundred("0.79");
        indexVO.setPositionCost("110.00");
        indexVO.setPositionMarketValue("111.00");
        securityIndex.setIndexVO(indexVO);
        return securityIndex;
    }
}
