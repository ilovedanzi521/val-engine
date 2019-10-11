/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-9/15:31
 * 项目名称: dfbp-fa-engine
 * 文件名称: ReadFileUtil.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.util;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.win.dfbp.val.manage.constant.ValMarketConstant;
import com.win.dfbp.val.manage.constant.ValMarketIntegratedConstant;
import com.win.dfbp.val.manage.constant.ValMarketZWConstant;
import com.win.dfbp.val.manage.entity.ValMarket;
import com.win.dfbp.val.manage.enumeration.DicEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.*;

/**
 * 包名称：com.win.dfbp.fa.manage.util
 * 类名称：ReadFileUtil
 * 类描述：
 * 创建人：@author zoujian
 * 创建时间：2019-10-9/15:31
 */
public class ReadFileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileUtil.class);

    /**
     * 读取中证txt行情数据
     * @Title: readTxt
     * @param filePath
     * @return: java.util.List<com.win.dfbp.fa.manage.entity.ValMarket>
     * @throws
     * @author: zoujian
     * @Date:  2019-10-9/15:40
     */
    public static  List<ValMarket> readTxt(String filePath) {
        // 行情数据数组
        List<ValMarket> marketList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                boolean isBegin = false;
                String beginStr = "==========";
                Map<String, Integer> fieldMap = new HashMap();
                int i = 0;
                while ((lineTxt = br.readLine()) != null) {
                    ValMarket valMarket =  ValMarket.getValMarket();
                    // 从==========开始，正式读取有效数据
                    if(isBegin){
                        String[] arrStrings = lineTxt.split("\\|");
                        if(arrStrings.length < 10){
                            LOGGER.info("数据有误！");
                            continue;
                        }
                        valMarket.setDataSource("zw");
                        // 日期
                        valMarket.setValuationDate(arrStrings[fieldMap.get(ValMarketZWConstant.VALUATION_DATE)].trim());
                        // 全价
                        valMarket.setFullPrice(arrStrings[fieldMap.get(ValMarketZWConstant.FULL_PRICE)].trim());
                        // 净价
                        valMarket.setNetPrice(arrStrings[fieldMap.get(ValMarketZWConstant.NET_PRICE)].trim());
                        valMarket.setFileTimestamp(new Date());
                        // 上交所证券代码
                        if(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_SH)] != null && !"".equals(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_SH)].trim())){
                            valMarket.setMarketCode("SH");
                            ValMarket valMarket1 =  ValMarket.getValMarket();
                            BeanUtils.copyProperties(valMarket,valMarket1);
                            valMarket1.setSecurityCode(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_SH)].trim());
                            marketList.add(valMarket1);
                        }
                        // 深交所证券代码
                        if(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_SZ)] != null && !"".equals(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_SZ)].trim())){
                            valMarket.setMarketCode("SZ");
                            ValMarket valMarket1 =  ValMarket.getValMarket();
                            BeanUtils.copyProperties(valMarket,valMarket1);
                            valMarket1.setSecurityCode(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_SZ)].trim());
                            marketList.add(valMarket1);
                        }
                        // 银行间债券代码
                        if(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_YH)] != null && !"".equals(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_YH)].trim())){
                            valMarket.setMarketCode("YH");
                            ValMarket valMarket1 =  ValMarket.getValMarket();
                            BeanUtils.copyProperties(valMarket,valMarket1);
                            valMarket1.setSecurityCode(arrStrings[fieldMap.get(ValMarketZWConstant.SECURITY_CODE_YH)].trim());
                            marketList.add(valMarket1);
                        }
                    }else{
                        // 排除==========这行的数据
                        if(!beginStr.equals(lineTxt)){
                            String[] arrStrings = lineTxt.split("=");
                            if(arrStrings.length == 2){
                                String code  = arrStrings[1].trim();
                                fieldMap.put(code,i);
                            }
                        }
                        i++;
                    }
                    if(beginStr.equals(lineTxt.trim())){
                        isBegin = true;
                    }
                }
            }
        }catch (Exception e) {
            LOGGER.info("文件读取错误！");
        }
        return marketList;
    }

    /**
     * 读取dbf行情文件
     * @Title: readDbf
     * @param filePath
     * @return: java.util.List<com.win.dfbp.val.manage.entity.ValMarket>
     * @throws
     * @author: zoujian
     * @Date:  2019-10-10/16:30
     */
    public static  List<ValMarket> readDbf(String filePath,boolean isIntegratedData) {
        // 行情数据数组
        List<ValMarket> marketList = new ArrayList<>();
        InputStream fis = null;
        try {
            // 读取文件的输入流
            fis = new FileInputStream(filePath);
            // 根据输入流初始化一个DBFReader实例，用来读取DBF文件信息
            DBFReader reader = new DBFReader(fis);
            reader.setCharactersetName("GBK");
            // 调用DBFReader对实例方法得到path文件中字段的个数
            int fieldsCount = reader.getFieldCount();
            // 取出字段信息
            Map fieldMap = new HashMap<Integer,String>(50);
            for (int i = 0; i < fieldsCount; i++) {
                DBFField field = reader.getField(i);
                fieldMap.put(i, field.getName());
            }
            Object[] rowValues;
            // 一条条取出path文件中记录
            while ((rowValues = reader.nextRecord()) != null) {
                ValMarket valMarket =  ValMarket.getValMarket();
                for (int i = 0; i < rowValues.length; i++) {
                    if(isIntegratedData){
                        if(ValMarketIntegratedConstant.SECURITY_CODE.equals(fieldMap.get(i))){
                            valMarket.setSecurityCode(rowValues[i].toString());
                        }
                        if(ValMarketIntegratedConstant.SECURITY_SHORT_NAME.equals(fieldMap.get(i))){
                            valMarket.setSecurityShortName(rowValues[i].toString());
                        }
                        if(ValMarketIntegratedConstant.VALUATION_DATE.equals(fieldMap.get(i))){
                            valMarket.setValuationDate(rowValues[i].toString());
                        }
                        if(ValMarketIntegratedConstant.FULL_PRICE.equals(fieldMap.get(i))){
                            valMarket.setFullPrice(rowValues[i].toString());
                        }
                        if(ValMarketIntegratedConstant.NET_PRICE.equals(fieldMap.get(i))){
                            valMarket.setNetPrice(rowValues[i].toString());
                        }
                        if(ValMarketIntegratedConstant.MARKET_CODE.equals(fieldMap.get(i))){
                            valMarket.setMarketCode(DicEnum.MarketEnum.getMarketCode(rowValues[i].toString().trim()));
                        }
                        if(ValMarketIntegratedConstant.RECOMMEND.equals(fieldMap.get(i))){
                            valMarket.setRecommend(DicEnum.RecommendEnum.getCode(rowValues[i].toString().trim()));
                        }
                    }else{
                        if(ValMarketConstant.SECURITY_CODE.equals(fieldMap.get(i))){
                            valMarket.setSecurityCode(rowValues[i].toString());
                        }
                        if(ValMarketConstant.SECURITY_SHORT_NAME.equals(fieldMap.get(i))){
                            valMarket.setSecurityShortName(rowValues[i].toString());
                        }
                        if(ValMarketConstant.VALUATION_DATE.equals(fieldMap.get(i))){
                            valMarket.setValuationDate(rowValues[i].toString());
                        }
                        if(ValMarketConstant.FULL_PRICE.equals(fieldMap.get(i))){
                            valMarket.setFullPrice(rowValues[i].toString());
                        }
                        if(ValMarketConstant.NET_PRICE.equals(fieldMap.get(i))){
                            valMarket.setNetPrice(rowValues[i].toString());
                        }
                        if(ValMarketConstant.MARKET_CODE.equals(fieldMap.get(i))){
                            valMarket.setMarketCode(DicEnum.MarketEnum.getMarketCode(rowValues[i].toString().trim()));
                        }
                        if(ValMarketConstant.RECOMMEND.equals(fieldMap.get(i))){
                            valMarket.setRecommend(DicEnum.RecommendEnum.getCode(rowValues[i].toString().trim()));
                        }
                    }
                    valMarket.setDataSource("ZG");
                    valMarket.setFileTimestamp(new Date());
                }
                // 排除交易市场为柜台和其他的数据
                if(valMarket.getSecurityCode() != null && !"".equals(valMarket.getSecurityCode().trim())
                        && !"GT".equals(valMarket.getMarketCode()) && !"QT".equals(valMarket.getMarketCode())){
                    marketList.add(valMarket);
                }
            }
            fis.close();
            // 去除同一证券代码中有多条数据  取推荐的数据
            if(marketList != null && marketList.size() > 1){
                for(int i = marketList.size() - 1 ; i > 0 ; i--){
                    // 如果存在同一证券代码 同一交易市场的数据 去推荐的数据
                    if(marketList.get(i).getSecurityCode() != null && marketList.get(i).getSecurityCode().equals(marketList.get(i-1).getSecurityCode())
                            && marketList.get(i).getMarketCode() != null && marketList.get(i).getMarketCode().equals( marketList.get(i-1).getMarketCode())){
                        String recommend = marketList.get(i).getRecommend();
                        if("Y".equals(recommend)){
                            marketList.remove(marketList.get(i-1));
                        }else{
                            marketList.remove(marketList.get(i));
                        }
                    }
                }
            }
            return  marketList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
