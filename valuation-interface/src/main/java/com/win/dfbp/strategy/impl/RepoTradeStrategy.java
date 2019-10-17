/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/10:09
 * 项目名称: dfbp-val-engine
 * 文件名称: RepoTradeStrategy.java
 * 文件描述: @Description: 回购交易策略
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.impl;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.strategy.BaseStrategy;
import org.springframework.stereotype.Service;

/**
 * 包名称：com.win.dfbp.strategy.impl
 * 类名称：RepoTradeStrategy
 * 类描述：回购交易策略
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/10:09
 */
@Service
public class RepoTradeStrategy extends BaseStrategy {
    @Override
    public SecurityIndexVO calInitIndex() {
        return null;
    }

    @Override
    public SecurityIndexVO calPositionIndex(SecurityIndex oldIndex) {
        return null;
    }
}
