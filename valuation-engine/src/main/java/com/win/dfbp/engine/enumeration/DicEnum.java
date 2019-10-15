/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-11/11:17
 * 项目名称: dfbp-fa-engine
 * 文件名称: DicEnum.java
 * 文件描述: @Description: 字典枚举类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.engine.enumeration;

/**
 * 包名称：com.win.dfbp.val.manage.enumeration
 * 类名称：DicEnum
 * 类描述：字典枚举类
 * 创建人：@author zoujian
 * 创建时间：2019-10-11/11:17
 */
public interface DicEnum {
    enum RecommendEnum{
        // 是否推荐枚举
        IS_RECOMMEND("Y","推荐"),
        NOT_RECOMMEND("N",""),
        ;
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        RecommendEnum(String code, String name){
            this.code = code;
            this.name = name;
        }

        public static String getCode(String name){
            String code = null;
            for(DicEnum.RecommendEnum recommendEnum : DicEnum.RecommendEnum.values()) {
                if (recommendEnum.name.equals(name)) {
                    code = recommendEnum.getCode();
                    break;
                }
            }
            return code;
        }
    }

    enum MarketEnum{
        // 交易市场枚举
        YH("YH","银行间债券市场"),
        SZ("SZ","深交所"),
        SH("SH","上交所"),
        GT("GT","柜台"),
        QT("QT","其他"),
        ;
        private String marketCode;
        private String marketName;

        public String getMarketCode() {
            return marketCode;
        }

        public String getMarketName() {
            return marketName;
        }
        MarketEnum(String marketCode, String marketName){
            this.marketCode = marketCode;
            this.marketName = marketName;
        }

        public static String getMarketCode(String marketName){
            String marketCode = null;
            for(DicEnum.MarketEnum marketEnum : DicEnum.MarketEnum.values()) {
                if (marketEnum.marketName.equals(marketName)) {
                    marketCode = marketEnum.getMarketCode();
                    break;
                }
            }
            return marketCode;
        }
    }
}
