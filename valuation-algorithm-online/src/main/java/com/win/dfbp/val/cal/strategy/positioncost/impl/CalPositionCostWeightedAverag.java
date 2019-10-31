/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/13:35
 * 项目名称: dfbp-val-engine
 * 文件名称: CalPositionCostWeightedAverag.java
 * 文件描述: @Description: 成本结转方式= 加权平均时持仓成本
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.cal.strategy.positioncost.impl;

import com.win.dfbp.val.cal.strategy.positioncost.ICalPositionCost;

import com.win.dfbp.val.common.constant.TradeDirectionConstant;
import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityIndexVO;
import com.win.dfbp.val.common.entity.SecurityParam;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 包名称：com.win.dfbp.strategy.positioncost.impl
 * 类名称：CalPositionCostWeightedAverag
 * 类描述：成本结转方式= 加权平均时持仓成本
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/13:35
 */
@Service
public class CalPositionCostWeightedAverag implements ICalPositionCost {

    @Override
    public BigDecimal cal(SecurityParam securityParam) {
        //所含利息
        BigDecimal tradeRates = securityParam.getTradeRates();
        tradeRates=(tradeRates==null?BigDecimal.ZERO:tradeRates);
        //交易金额
        BigDecimal tradeAmt = securityParam.getCashSettleBalance().subtract(tradeRates);
        return tradeAmt;
    }

    @Override
    public BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam) {
        //所含利息
        BigDecimal tradeRates = securityParam.getTradeRates();
        tradeRates=(tradeRates==null?BigDecimal.ZERO:tradeRates);
        //判断交易方向
        String tradeDirection = securityParam.getTradeDirection();
        //前一持仓指标
        SecurityIndexVO indexVO = oldIndex.getIndexVO();
        //前一持仓数量
        BigDecimal oldPositionAmount =  indexVO.getPositionAmount();
        //前一持仓成本
        BigDecimal oldPositionCost =  indexVO.getPositionCost().subtract(tradeRates);
        //交易金额
        BigDecimal tradeAmt = securityParam.getCashSettleBalance();
        //交易数量
        BigDecimal tradeAmount = securityParam.getStockSettleAmount();
        switch(tradeDirection){
            case TradeDirectionConstant.BUY:{
                return oldPositionCost.add(tradeAmt);
            }
            /**
             * 卖出成本=当比卖出数量/ 前一持仓数量   * 前一持仓成本，
             * 卖出剩余持仓成本 =  前一持仓成本  - 卖出成本
             */
            case TradeDirectionConstant.SELL:{
                return oldPositionCost.subtract(tradeAmount.divide(oldPositionAmount,securityParam.getDecimalAccuracy(), RoundingMode.HALF_EVEN).
                        multiply(oldPositionCost)).
                        setScale(securityParam.getDecimalAccuracy(), RoundingMode.HALF_EVEN);
            }
            default:{
                return oldPositionAmount.add(tradeAmt);
            }
        }
    }
}
