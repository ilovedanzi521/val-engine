/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/23/9:16
 * 项目名称: dfbp-val-engine
 * 文件名称: ValParamScheme.java
 * 文件描述: @Description: 估值参数方案
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import lombok.Data;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：ValParamScheme
 * 类描述：估值参数方案
 * 创建人：@author wanglei
 * 创建时间：2019/10/23/9:16
 */
@Data
public class ValParamScheme {
    private String fundNo;
    /**
     * 产品对应配置的参数方案
     */
    private String valSchemeCode;
}
