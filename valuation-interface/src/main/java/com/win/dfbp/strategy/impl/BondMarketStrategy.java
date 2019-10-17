/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-17/16:58
 * 项目名称: dfbp-fa-engine
 * 文件名称: BondMarketStrategy.java
 * 文件描述: @Description: 行情--债券数据指标更新策略类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.strategy.impl;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.InvestFlagConstant;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.constant.ValPositionConstant;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.ValMarket;
import com.win.dfbp.strategy.BaseMarketStrategy;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 包名称：com.win.dfbp.strategy.impl
 * 类名称：BondMarketStrategy
 * 类描述：行情--债券数据指标更新策略类
 * 创建人：@author zoujian
 * 创建时间：2019-10-17/16:58
 */
@Service
public class BondMarketStrategy extends BaseMarketStrategy {
    @Override
    public SecurityIndexVO calPositionIndex(ValMarket valMarket,  LinkedHashMap securityMap) {
        // 3、判断是否持仓
        // 持仓缓存存储格式 eg: VAL_POSITION-010107-SH-
        List<Object> testList = RedisUtil.matchGet(RedisKeyPrefix.VAL_POSITION + CommonConstants.HORIZONTAL_LINE
                + valMarket.getSecurityCode() + CommonConstants.HORIZONTAL_LINE + valMarket.getMarketCode() + CommonConstants.ASTERISK);
        String key = valMarket.getSecurityCode() + CommonConstants.DOT + valMarket.getMarketCode();
        for (Object ob: testList){
            LinkedHashMap map = (LinkedHashMap) ob;
            // 持有到期的债券 不计算其相应的指标
            if(InvestFlagConstant.FLAG_C.equals(map.get(ValPositionConstant.INVEST_FLAG))){
               continue;
            }
            // 4、匹配估值标准

            // 5、计算公允价
        }
        return null;
    }
}
