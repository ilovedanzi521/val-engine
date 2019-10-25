/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/11:36
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionCost.java
 * 文件描述: @Description: 计算持仓成本
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.cal.m1;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfas.common.util.SpringContextUtil;
import com.win.dfbp.cal.ISecurityCalculation;
import com.win.dfbp.cal.strategy.fairprice.FairPriceFactory;
import com.win.dfbp.cal.strategy.positioncost.PositionCostFactory;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.TradeRuleConstant;
import com.win.dfbp.entity.FundParam;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.cal.m1
 * 类名称：CalPositionCost
 * 类描述：计算持仓成本
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/11:36
 */
@Slf4j
public class CalPositionCost implements ISecurityCalculation {
    private static final String clz = CalPositionCost.class.getName();
    private PositionCostFactory positionCostFactory = SpringContextUtil.getBean(PositionCostFactory.class);
    @Override
    public boolean isAlgorithmSupported(String algorithm) {
        if(clz.equals(algorithm)){
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        //2.获取成本转结方式
        Object costAccount = RedisUtil.get(RedisKeyPrefix.FUND_VAL_PARAM_CONFIG+ CommonConstants.HORIZONTAL_LINE+
                securityParam.getFundNo()+CommonConstants.HORIZONTAL_LINE+TradeRuleConstant.VAL_PARAM_DIC_FP001);
        if(ObjectUtil.isEmpty(costAccount)){
            log.error("无法成本转结方式:{}",RedisKeyPrefix.FUND_VAL_PARAM_CONFIG+ CommonConstants.HORIZONTAL_LINE+
                    securityParam.getFundNo()+CommonConstants.HORIZONTAL_LINE+TradeRuleConstant.VAL_PARAM_DIC_FP001);
        }else{
            FundParam tmpParam = JSON.parseObject(JSON.toJSONString(costAccount), FundParam.class);
            BigDecimal positionCost = positionCostFactory.getInstance(tmpParam.getMethodCode()).cal(securityParam);
            return positionCost;
        }
        return BigDecimal.ONE;
    }

    @Override
    public BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam) {
        //计算持仓成本
        //2.获取成本转结方式
        return cal(securityParam);

    }
}
