/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/11:24
 * 项目名称: dfbp-val-engine
 * 文件名称: ICalFairPrice.java
 * 文件描述: @Description: 计算公允价
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.strategy.fairprice;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.exception.WinException;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.SecurityParam;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy.fairprice
 * 类名称：ICalFairPrice
 * 类描述：计算公允价
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/11:24
 */
public abstract class AbsCalFairPrice {
    /**
     * @Title: cal
     * @Description 计算公允价
     * @param securityParam
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/18/11:50
     */
    public abstract BigDecimal cal(SecurityParam securityParam);

    public BigDecimal calFairPrice(SecurityParam securityParam){
        return cal(securityParam.calPrice().calInterest());
    }
}
