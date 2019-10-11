/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:24
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexState.java
 * 文件描述: @Description: 指标状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.state;

import lombok.Data;

import java.io.Serializable;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexState
 * 类描述：指标状态
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:24
 */
@Data
public class SecurityIndexState implements Serializable {
    /**
     * 产品代码
     */
    private String fundNo;
    /**
     * 产品性质
     */
    private String fundCharacter;
    /**
     * 组合代码
     */
    private String portfNo;
    /**
     *  证券代码
     */
    private String securityCode;
    /**
     * 交易市场
     */
    private String marketCode;
    /**
     * 交易平台
     */
    private String platformCode;
    /**
     * 证券性质
     */
    private String securityCharacter;
    /**
     * 投资标志
     */
    private String investFlag;
    /**
     * 指标
     */
    private SecurityIndexVO indexVO;
}
