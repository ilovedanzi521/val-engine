/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-17/17:01
 * 项目名称: dfbp-fa-engine
 * 文件名称: RepoMarketStrategy.java
 * 文件描述: @Description:
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.core.strategy.impl;

import com.win.dfbp.val.common.entity.SecurityParam;
import com.win.dfbp.val.core.entity.ValMarket;
import com.win.dfbp.val.core.strategy.BaseMarketStrategy;
import org.springframework.stereotype.Service;

/**
 * 包名称：com.win.dfbp.strategy.impl
 * 类名称：RepoMarketStrategy
 * 类描述：行情--回购数据指标更新策略类
 * 创建人：@author zoujian
 * 创建时间：2019-10-17/17:01
 */
@Service
public class RepoMarketStrategy extends BaseMarketStrategy {
    @Override
    public SecurityParam calPositionIndex(ValMarket valMarket, SecurityParam securityParam) {
        return null;
    }
}
