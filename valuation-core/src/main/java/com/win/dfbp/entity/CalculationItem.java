/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/24/15:39
 * 项目名称: dfbp-val-engine
 * 文件名称: CalculationItem.java
 * 文件描述: @Description: 计算因子
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import lombok.Data;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：CalculationItem
 * 类描述：计算因子
 * 创建人：@author wanglei
 * 创建时间：2019/10/24/15:39
 */
@Data
public class CalculationItem {
    /**
     * 计算因子
     */
    private String calItem;
    /**
     * 计算因子表达式
     */
    private String calFormula;
}
