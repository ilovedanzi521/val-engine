/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:24
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexVO.java
 * 文件描述: @Description: 指标
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import com.win.dfbp.constant.TradeRuleConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexVO
 * 类描述：指标
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:24
 */
@Data
public class SecurityIndexVO {
    /**
     * 持仓数量
     */
    private BigDecimal positionAmount;
    /**
     * 持仓成本
     */
    private BigDecimal positionCost;
    /**
     * 持仓市值
     */
    private BigDecimal positionMarketValue;
    /**
     * 百元利率
     */
    private BigDecimal interestRateOfHundred;
    /**
     * 公允价格
     */
    private BigDecimal fairPrice;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 浮动盈亏
     */
    private BigDecimal floatingPL;
    /**
     * @Title: setIndex
     * @Description 根据classcode设置指标
     * @param classCode
     * @param value
     * @return com.win.dfbp.entity.SecurityIndexVO
     * @throws
     * @author wanglei
     * @Date 2019/10/24/15:27
     */
    public SecurityIndexVO setIndex(String classCode,BigDecimal value){
       switch(classCode){
           case TradeRuleConstant.VAL_CLASS_DIC_VC001:{
                this.setPositionCost(value);
                break;
           }
           case TradeRuleConstant.VAL_CLASS_DIC_VC002:{
               this.setFairPrice(value);
               break;
           }
           case TradeRuleConstant.VAL_CLASS_DIC_VC003:{
               this.setPositionMarketValue(value);
               break;
           }
           case TradeRuleConstant.VAL_CLASS_DIC_VC004:{
               this.setCostPrice(value);
               break;
           }
           case TradeRuleConstant.VAL_CLASS_DIC_VC005:{
               this.setFloatingPL(value);
               break;
           }
           case TradeRuleConstant.VAL_CAL_ITEM_I004:{
               this.setPositionAmount(value);
               break;
           }
           case TradeRuleConstant.VAL_CAL_ITEM_I002:{
               this.setInterestRateOfHundred(value);
               break;
           }
           default:{
               return this;
           }
       }
        return this;
    }
}
