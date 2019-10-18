/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:24
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexVO.java
 * 文件描述: @Description: 指标
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.entity;

import lombok.Data;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexVO
 * 类描述：指标
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:24
 */

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：SecurityParam
 * 类描述：证券参数
 * 创建人：@author wanglei
 * 创建时间：2019/10/17/19:23
 */
@Data
public class SecurityParam {
    //入参：资产类别
    private String assetType;
    /**
     *入参：证券类别
     */
    private String securityType;
    /**
     *入参：市场
     */
    private String marketCode;
    /**
     *入参：证券代码
     */
    private String securityCode;

    /**
     *入参：是否贴现
     */
    private String isDiscount;
    /**
     * 出参：估值标准
     */
    private String valCriteria;
    /**
     * 、保留位数
     */
    private String decimalAccuracy;

    /**
     * 来源
     */
    private String source;


    public String levelKey(int level){
        switch (level){
            case 1:{
                return assetType+securityType+marketCode+securityCode;
            }
            case 2:{
                return assetType+securityType+marketCode+isDiscount;
            }
            case 3:{
                return assetType+securityType+isDiscount;
            }
            case 4:{
                return assetType+securityType+marketCode;
            }
            case 5:{
                return assetType+isDiscount;
            }
            case 6:{
                return assetType+marketCode;
            }
        }
        return "";
    }

}
