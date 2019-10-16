/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/10:09
 * 项目名称: dfbp-val-engine
 * 文件名称: BankTradeStrategy.java
 * 文件描述: @Description: 银行间交易策略
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.impl;

import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.strategy.BaseStrategy;
import org.springframework.stereotype.Service;

/**
 * 包名称：com.win.dfbp.strategy.impl
 * 类名称：BankTradeStrategy
 * 类描述：银行间交易策略
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/10:09
 */
@Service
public class BankTradeStrategy extends BaseStrategy {


    @Override
    public SecurityIndexVO calInitIndex() {
        return null;
    }

    @Override
    public SecurityIndexVO calPositionIndex() {
        return null;
    }
}
