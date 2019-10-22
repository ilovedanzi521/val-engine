/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-16/16:09
 * 项目名称: dfbp-fa-engine
 * 文件名称: SecurityBasicInfo.java
 * 文件描述: @Description: 证券基础信息
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 包名称：com.win.dfbp.entity
 * 类名称：SecurityBasicInfo
 * 类描述：证券基础信息
 * 创建人：@author zoujian
 * 创建时间：2019-10-16/16:09
 */
@ApiModel(value = "证券基础信息类")
@Data
public class SecurityBasicInfo {

    @ApiModelProperty(value = "证券代码")
    private String securityCode;

    @ApiModelProperty(value = "证券名称")
    private String securityName;

    @ApiModelProperty(value = "证券类别")
    private String securityType;

    @ApiModelProperty(value = "交易市场")
    private String marketCode;

    @ApiModelProperty(value = "资产类别")
    private String assetType;
}
