/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/15/16:52
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisKeyPrefix.java
 * 文件描述: @Description: redis缓存key前缀
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.common.constant;

/**
 * 包名称：com.win.dfbp.val.manage.constant
 * 类名称：RedisKeyPrefix
 * 类描述：redis缓存key前缀
 * 创建人：@author wanglei
 * 创建时间：2019/10/15/16:52
 */
public class RedisKeyPrefix {
    /**
     *  估值类型
     *  'VC001', '持仓成本'
     * 'VC002', '公允价',
     * 'VC003', '持仓市值'
     * 'VC004', '成本价',
     * 'VC005', '浮动盈亏'
     */
    public static final String VAL_CLASS = "VAL_CLASS";
    /**
     * 计算因子
     * 'I001', '净价'
     * 'I002', '百元利息'
     * 'I003', '全价'
     * 'I004', '持仓数量'
     */
    public static final String CAL_ITEM = "CAL_ITEM";
    /**
     * 产品状态
     * '1', '正常'
     * '2', '注销'
     */
    public static final String FUND_STATUS = "FUND_STATUS";
    /**
     * 产品性质
     */
    public static final String FUND_CHARACTER = "FUND_CHARACTER";
    /**
     * 成本转结
     */
    public static final String COST_CARRY = "COST_CARRY";
    /**
     * 成本核算顺序
     */
    public static final String COST_ORDER = "COST_ORDER";
    /**
     * 实际利率
     */
    public static final String REAL_RATE = "REAL_RATE";
    /**
     * 估值来源
     * 'S001',- '交易所行情',
     * 'S003',- '中证债券行情
     * 'S004',-'中债债券行情
     */
    public static final String VAL_SOURC = "VAL_SOURC";
    /**
     * 估值标准
     * 'P001' -'净价'
     * 'P002' -'净价加税百元利息'
     * 'P003' -'全价'
     * 'P004' -'全价减税前百元利息'
     * 'P005' -'全价减税后百元利息'
     * 'P006' -'成本'
     */
    public static final String VAL_CRITERIA = "VAL_CRITERIA";
    /**
     * 产品估值分类对应的算法公式和算法模块缓存
     */
    public static final String FUND_VAL_CLASS_CONFIG = "FUND_VAL_CLASS_CONFIG";

    /**
     * 产品估值分类对应的计算参数，成本转结、成本核素顺序等参数配置
     */
    public static final String FUND_VAL_PARAM_CONFIG = "FUND_VAL_PARAM_CONFIG";

    /**
     * 产品参数方案
     */
    public static final String FUND_VAL_SCHEME = "FUND_VAL_SCHEME";
    /**
     * 百元汇率
     */
    public static final String VAL_INTEREST = "VAL_INTEREST";
    /**
     * 证券基础信息
     */
    public static final String VAL_SECURITY_INFO = "VAL_SECURITY_INFO";

    /**
     * 持仓信息
     */
    public static final String VAL_POSITION = "VAL_POSITION";

    /**
     * 估值标准方案明细
     */
    public static final String VAL_CRITERIA_SCHEME_DETAIL = "VAL_PARAM";

    /**
     * 最新行情信息
     */
    public static final String VAL_MARKET = "VAL_MARKET";


}
