/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-17/16:37
 * 项目名称: dfbp-fa-engine
 * 文件名称: BaseMarketStrategy.java
 * 文件描述: @Description: 基础行情策略抽象类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.strategy;

import com.win.dfbp.entity.SecurityBasicInfo;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.SecurityParam;
import com.win.dfbp.entity.ValMarket;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * 包名称：com.win.dfbp.strategy
 * 类名称：BaseMarketStrategy
 * 类描述：基础行情策略抽象类
 * 创建人：@author zoujian
 * 创建时间：2019-10-17/16:37
 */
@Service
public abstract class BaseMarketStrategy {
    /**
     * 计算持仓指标
     * @Title: calPositionIndex
     * @param valMarket 行情数据
     * @param securityParam  证券信息
     * @return: com.win.dfbp.entity.SecurityIndexVO
     * @throws
     * @author: zoujian
     * @Date:  2019-10-17/16:43
     */
    public abstract SecurityParam calPositionIndex(ValMarket valMarket, SecurityParam securityParam);
}
