/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-9/15:29
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValMarket.java
 * 文件描述: @Description:
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 包名称：com.win.dfbp.val.manage.entity
 * 类名称：ValMarket
 * 类描述：行情数据实体类
 * 创建人：@author zoujian
 * 创建时间：2019-10-9/10:52
 */
@ApiModel(value = "行情数据实体类")
@Data
public class ValMarket implements Cloneable{
    private static final long serialVersionUID = 1L;

    private static ValMarket valMarket = new ValMarket();

    public static ValMarket getValMarket(){
        try{
            return (ValMarket)valMarket.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();

        }
        return  null;
    }

    private ValMarket(){}

    @ApiModelProperty(value = "证券代码")
    private String securityCode;

    @ApiModelProperty(value = "全价")
    private String fullPrice;

    @ApiModelProperty(value = "净价")
    private String netPrice;

    @ApiModelProperty(value = "证券代码简称")
    private String securityShortName;

    @ApiModelProperty(value = "估值日期")
    private String valuationDate;

    @ApiModelProperty(value = "行情来源")
    private String dataSource;

    @ApiModelProperty(value = "文件时间戳")
    private Date fileTimestamp;

    @ApiModelProperty(value = "交易市场")
    private String marketCode;

    @ApiModelProperty(value = "是否推荐")
    private String recommend;
}
