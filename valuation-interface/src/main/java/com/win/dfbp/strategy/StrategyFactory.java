/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/9:17
 * 项目名称: dfbp-val-engine
 * 文件名称: StrategyFactory.java
 * 文件描述: @Description: 策略工厂
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy;

import com.win.dfbp.constant.AssetTypeConstant;
import com.win.dfbp.strategy.impl.BondTradeStrategy;
import com.win.dfbp.strategy.impl.RepoTradeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 包名称：com.win.dfbp.strategy
 * 类名称：StrategyFactory
 * 类描述：策略工厂
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/9:17
 */
@Component
public class StrategyFactory {
    @Autowired
    private  BondTradeStrategy bondTradeStrategy;
    @Autowired
    private  RepoTradeStrategy repoTradeStrategy;
    public BaseStrategy getPromotionStrategy(String promotionKey){
       switch (promotionKey){
           case AssetTypeConstant.BOND:{
               return bondTradeStrategy;
           }
           case AssetTypeConstant.REPO:{
               return repoTradeStrategy;
           }
           default:{
               return repoTradeStrategy;
           }
        }
    }
}
