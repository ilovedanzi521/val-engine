/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/19:09
 * 项目名称: dfbp-val-engine
 * 文件名称: FundParam.java
 * 文件描述: @Description: 产品配置的参数
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import lombok.Data;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：FundParam
 * 类描述：产品配置的参数
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/19:09
 */
@Data
public class FundParam {
    private String fundNo;
    private String paramCode;
    private String methodCode;
}
