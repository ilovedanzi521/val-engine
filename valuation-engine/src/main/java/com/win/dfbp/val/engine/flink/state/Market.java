/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/29/9:11
 * 项目名称: dfbp-val-engine
 * 文件名称: MarketState.java
 * 文件描述: @Description: 行情状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.engine.flink.state;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.engine.flink.state
 * 类名称：MarketState
 * 类描述：行情状态
 * 创建人：@author wanglei
 * 创建时间：2019/10/29/9:11
 */
@Data
public class Market implements Serializable{
    /**
     * 证券代码
     */
    private String securityCode;
    /**
     * 市场代码
     */
    private String markCode;
    /**
     * 数据来源
     */
    private String dataSource;
    /**
     * 公允价
     */
    private BigDecimal fairPrice;
    public String key(){
        return this.securityCode;
    }
}
