/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/10:01
 * 项目名称: dfbp-val-engine
 * 文件名称: BaseStrategy.java
 * 文件描述: @Description: 不同证券类型的计算策略
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy;

import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy
 * 类名称：BaseStrategy
 * 类描述：不同证券类型的计算策略
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/10:01
 */
public abstract class BaseStrategy {
    /**
     * @Title: calInitIndex
     * @Description 计算初始指标
     * @param
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/16/10:19
     */
    public abstract SecurityIndexVO calInitIndex();
    /**
     * @Title: calPositionIndex
     * @Description 计算持仓指标
     * @param
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/16/10:20
     */
    public abstract SecurityIndexVO calPositionIndex();
}
