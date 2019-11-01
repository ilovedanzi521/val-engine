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

package com.win.dfbp.val.core.strategy;

import com.win.dfbp.val.core.strategy.impl.BondMarketStrategy;
import com.win.dfbp.val.core.strategy.impl.RepoMarketStrategy;
import com.win.dfbp.val.core.constant.AssetTypeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 包名称：com.win.dfbp.strategy
 * 类名称：StrategyFactory
 * 类描述：行情触发--策略工厂
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/9:17
 */
@Component
public class MarketStrategyFactory {
    @Autowired
    private BondMarketStrategy bondMarketStrategy ;
    @Autowired
    private RepoMarketStrategy repoMarketStrategy ;
    public  BaseMarketStrategy getPromotionStrategy(String promotionKey){
        if(AssetTypeConstant.BOND.equals(promotionKey)){
            return bondMarketStrategy;
        }
        if(AssetTypeConstant.REPO.equals(promotionKey)){
            return repoMarketStrategy;
        }
        return null;
    }

}
