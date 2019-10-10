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

import com.win.dfbp.val.manage.entity.ValMarket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
                        valMarket.setValuationDate(arrStrings[0]);
                        // 全价
                        valMarket.setFullPrice(arrStrings[4]);
                        // 净价
                        valMarket.setNetPrice(arrStrings[8]);
                        // 上交所证券代码
                        if(arrStrings[1] != null && !"".equals(arrStrings[1].trim())){
                            ValMarket valMarket1 =  ValMarket.getValMarket();
                            BeanUtils.copyProperties(valMarket,valMarket1);
                            valMarket1.setSecurityCode(arrStrings[1]);
                            marketList.add(valMarket1);
                        }
                        // 深交所证券代码
                        if(arrStrings[2] != null && !"".equals(arrStrings[2].trim())){
                            ValMarket valMarket1 =  ValMarket.getValMarket();
                            BeanUtils.copyProperties(valMarket,valMarket1);
                            valMarket1.setSecurityCode(arrStrings[2]);
                            marketList.add(valMarket1);
                        }
                        // 银行间债券代码
                        if(arrStrings[3] != null && !"".equals(arrStrings[3].trim())){
                            ValMarket valMarket1 =  ValMarket.getValMarket();
                            BeanUtils.copyProperties(valMarket,valMarket1);
                            valMarket1.setSecurityCode(arrStrings[3]);
                            marketList.add(valMarket1);
                        }
                    }
                    if(beginStr.equals(lineTxt)){
                        isBegin = true;
                    }
                }

            }
        }catch (Exception e) {
            LOGGER.info("文件读取错误！");
        }
        return marketList;
    }
}
