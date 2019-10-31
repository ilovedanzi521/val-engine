/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/29/9:16
 * 项目名称: dfbp-val-engine
 * 文件名称: ConnectState.java
 * 文件描述: @Description: 合并状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.engine.flink.state;

import com.win.dfbp.val.common.entity.SecurityIndex;

import java.io.Serializable;

/**
 * 包名称：com.win.dfbp.engine.flink.state
 * 类名称：ConnectState
 * 类描述：合并状态
 * 创建人：@author wanglei
 * 创建时间：2019/10/29/9:16
 */
public class ConnectState implements Serializable {
    private Market market;
    private SecurityIndex securityIndex;

    public Market getMarket() {
        return market;
    }

    public ConnectState setMarket(Market market) {
        this.market = market;
        return this;
    }

    public SecurityIndex getSecurityIndex() {
        return securityIndex;
    }

    public ConnectState setSecurityIndex(SecurityIndex securityIndex) {
        this.securityIndex = securityIndex;
        return this;
    }
}
