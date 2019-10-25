/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/14:30
 * 项目名称: dfbp-val-engine
 * 文件名称: CalculationValClass.java
 * 文件描述: @Description: 计算项
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import lombok.Data;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：CalculationValClass
 * 类描述：计算项
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/14:30
 */
@Data
public class CalculationValClass {
    private String fundNo;
    private String classCode;
    private String methodCode;
    private int calType;
    private String calModel;
}
