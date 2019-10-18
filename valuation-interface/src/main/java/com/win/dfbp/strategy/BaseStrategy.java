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

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.exception.WinException;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import com.win.dfbp.entity.SecurityParam;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.strategy
 * 类名称：BaseStrategy
 * 类描述：不同证券类型的计算策略
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/10:01
 */
@Slf4j
public abstract class BaseStrategy {
    protected SecurityIndex securityIndex;

    public SecurityIndex getSecurityIndex() {
        return securityIndex;
    }

    public void setSecurityIndex(SecurityIndex securityIndex) {
        this.securityIndex = securityIndex;
    }
    /**
     * @Title: calInitIndex
     * @Description 计算初始指标
     * @param
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/16/10:19
     */
    public SecurityIndexVO initIndex(SecurityIndex securityIndex,String securityCode){
        SecurityParam securityParam = querySecurityBasciInfo(securityCode);
        if(securityParam==null){
            throw new WinException("没有存在证券基础信息");
        }
        return calInitIndex(securityParam);
    }
    public abstract SecurityIndexVO calInitIndex(SecurityParam securityParam);
    /**
     * @Title: calPositionIndex
     * @Description 计算持仓指标
     * @param
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/16/10:20
     */
    public SecurityIndexVO positionIndex(SecurityIndex oldIndex){
        SecurityParam securityParam = querySecurityBasciInfo(oldIndex.getSecurityCode());
        if(securityParam==null){
            throw new WinException("没有存在证券基础信息");
        }
        return calInitIndex(securityParam);
    }
    public abstract SecurityIndexVO calPositionIndex(SecurityIndex oldIndex,SecurityParam securityParam);

    /**
     * @Title: querySecurityBasciInfo
     * @Description 判断证券信息
     * @param securityCode
     * @return com.win.dfbp.entity.SecurityParam
     * @throws
     * @author wanglei
     * @Date 2019/10/18/10:45
     */
    public SecurityParam querySecurityBasciInfo(String securityCode){
        //缓存中获取证券信息
        Object securityInfo = RedisUtil.get(RedisKeyPrefix.VAL_SECURITY_INFO+ CommonConstants.HORIZONTAL_LINE+securityCode);
        SecurityParam securityParam = null;
        if(ObjectUtil.isEmpty(securityInfo)){
            log.error("证券基础信息没有加载缓存！");
        }else{
            //1 . json转object 获取证券内码对用的证券基础信息
            securityParam = JSON.parseObject((String)securityInfo,SecurityParam.class);
        }
        return securityParam;
    }
}
