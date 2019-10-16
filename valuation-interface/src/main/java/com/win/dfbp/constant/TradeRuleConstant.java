/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/16/10:44
 * 项目名称: dfbp-val-engine
 * 文件名称: TradeRuleConstant.java
 * 文件描述: @Description: 涉及交易规则或交易的常量
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.constant;

/**
 * 包名称：com.win.dfbp.constant
 * 类名称：TradeRuleConstant
 * 类描述：涉及交易规则或交易的常量
 * 创建人：@author wanglei
 * 创建时间：2019/10/16/10:44
 */
public class TradeRuleConstant {
    /**
     *  投资标志
     *  J-交易性金融资产
     */
    private static String INVEST_FLAG_J ="J";
    /**
     *  投资标志
     *  F-可供出售类金融资产
     */
    private static String INVEST_FLAG_F ="F";
    /**
     *  投资标志
     *  C-持有至到期投资
     */
    private static String INVEST_FLAG_C ="C";
    /**
     * 投资标志
     * Y-贷款应收款
     */
    private static String INVEST_FLAG_Y ="Y";


    /**
     *  投资标志
     *  J-净价
     */
    private static String VAL_CRITERIA ="J";
    /**
     *  估值标准参数方法
     *  'P001'-'净价'
     */
    private static String VAL_CRITERIA_P001 ="P001";
    /**
     *  估值标准参数方法
     *  'P002'-'净价加税百元利息'
     */
    private static String VAL_CRITERIA_P002 ="P002";
    /**
     * 估值标准参数方法
     * 'P003'-'全价'
     */
    private static String VAL_CRITERIA_P003 ="P003";
    /**
     * 估值标准参数方法
     * 'P004'-'全价减税前百元利息
     */
    private static String VAL_CRITERIA_P004 ="P004";
    /**
     * 估值标准参数方法
     * 'P005'-'全价减税后百元利息
     */
    private static String VAL_CRITERIA_P005 ="P005";
    /**
     * 估值标准参数方法
     * 'P006'-'成本'
     */
    private static String VAL_CRITERIA_P006 ="P006";
}
