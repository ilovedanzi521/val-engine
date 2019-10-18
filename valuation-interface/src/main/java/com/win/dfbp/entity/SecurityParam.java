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

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.exception.WinException;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.constant.RedisKeyPrefix;
import lombok.Data;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeSet;

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
    private int decimalAccuracy;

    /**
     * 来源
     */
    private String source;

    /**
     * 来源获取净价
     */
    private BigDecimal netPrice;

    /**
     * 来源获取全价
     */
    private BigDecimal fullPrice;
    /**
     *税前计息每百元利息';
     */
    private BigDecimal pretaxInterest;

    /**
     * 税后计息每百元利息';
     */
    private BigDecimal aftertaxInterest;

    /**
     *持仓数量';
     */
    private BigDecimal positionAmount;

    /**
     * 持仓成本';
     */
    private BigDecimal positionCost;
    /**
     * 公允价
     */
    private BigDecimal fairPrice;

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
    /**
     * @Title: calFairPrice
     * @Description 计算净价全价
     * @param
     * @return java.math.BigDecimal
     * @throws
     * @author wanglei
     * @Date 2019/10/18/11:49
     */
    public SecurityParam calPrice(){
        //根据证券代码+交易市场+来源获取净价全价
        Object price = RedisUtil.get(RedisKeyPrefix.VAL_MARKET+ CommonConstants.HORIZONTAL_LINE+
                this.getSecurityCode()+this.getMarketCode()+this.getSource());
        if(ObjectUtil.isEmpty(price)){
            throw new WinException("无法获取行情的净价全价信息");
        }else{
            SecurityParam tmpParam = JSON.parseObject(JSON.toJSONString(price),SecurityParam.class);
            this.setFullPrice(tmpParam.getFullPrice());
            this.setNetPrice(tmpParam.getNetPrice());
            return this;
        }
    }
    /**
     * @Title: BigDecimal
     * @Description 获取百元利率
     * @param
     * @return
     * @throws
     * @author wanglei
     * @Date 2019/10/18/11:49
     */
    public SecurityParam calInterest (){
        //根据证券代码+交易市场+来源获取净价全价
        Object interest = RedisUtil.get(RedisKeyPrefix.VAL_INTEREST+ CommonConstants.HORIZONTAL_LINE+
                this.getSecurityCode()+this.getMarketCode());
        if(ObjectUtil.isEmpty(interest)){
            throw new WinException("无法获取百元利息信息");
        }else{
            SecurityParam tmpParam = JSON.parseObject(JSON.toJSONString(interest),SecurityParam.class);
            this.setPretaxInterest(tmpParam.getPretaxInterest());
            this.setAftertaxInterest(tmpParam.getAftertaxInterest());
            return this;
        }
    }

    /**
     * @Title: getSecurityParam
     * @Description 获取证券信息，
     * @param
     * @return com.win.dfbp.entity.SecurityParam
     * @throws
     * @author wanglei
     * @Date 2019/10/18/10:17
     */
    public SecurityParam setSecurityParam() {
        TreeSet<String> keys =new TreeSet<>();
        for (int i =1;i<=6;i++){
            keys.add(RedisKeyPrefix.VAL_CRITERIA_SCHEME_DETAIL+ CommonConstants.HORIZONTAL_LINE+levelKey(i));
        }
        //批量获取keys
        List list = RedisUtil.multiGet(keys);
        if(ObjectUtil.isNotEmpty(list)){
            for (Object rt : list) {
                if(rt!=null){
                    SecurityParam tmpParam = JSON.parseObject(JSON.toJSONString(rt),SecurityParam.class);
                    this.setDecimalAccuracy(tmpParam.getDecimalAccuracy());
                    this.setValCriteria(tmpParam.getValCriteria());
                    this.setSource(tmpParam.getSource());
                    return this;
                }
            }
        }else{
            throw new WinException("无法获取估值参数信息");
        }
        return this;
    }
}
