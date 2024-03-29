/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/14/10:16
 * 项目名称: dfbp-val-engine
 * 文件名称: ISecurityCalculation.java
 * 文件描述: @Description: 证券估值计算接口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.cal;


import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityParam;


import java.math.BigDecimal;

/**
 * 包名称：com.win.dfbp.cal
 * 类名称：ISecurityCalculation
 * 类描述：证券估值计算接口
 * 创建人：@author wanglei
 * 创建时间：2019/10/14/10:16
 */
public interface ISecurityCalculation {
    /**
     * @Title: isAlgorithmSupported
     * @Description 判断算法是否支持
     * @param algorithm
     * @return boolean
     * @throws
     * @author wanglei
     * @Date 2019/10/14/10:17
     */
    boolean isAlgorithmSupported(String algorithm);
    /**
     * @Title: calculateSecurityIndex
     * @Description  计算证券指标
     * @return com.win.dfbp.entity.SecurityIndex
     * @throws
     * @author wanglei
     * @Date 2019/10/14/10:33
     * @param securityParam
     */
    BigDecimal cal(SecurityParam securityParam);

    BigDecimal cal(SecurityIndex oldIndex, SecurityParam securityParam);
}
