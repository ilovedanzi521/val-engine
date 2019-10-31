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
public class CalculationValClass implements Comparable<CalculationValClass>{
    /**
     * 产品
     */
    private String fundNo;
    /**
     * 计算项
     */
    private String classCode;
    /**
     * 计算方法
     */
    private String methodCode;
    /**
     * 计算方式
     */
    private int calType;
    /**
     * 计算模块 classpath
     */
    private String calModel;
    /**
     * 计算顺序
     */
    private int calOrder;
    /**
     * @Title: compareTo
     * @Description 计算项，计算排序,根据缓存中calOrder字段排序
     * @param other
     * @return int
     * @throws
     * @author wanglei
     * @Date 2019/10/31/14:25
     */
    @Override
    public int compareTo(CalculationValClass other) {
        return this.calOrder - other.calOrder;
    }
}
