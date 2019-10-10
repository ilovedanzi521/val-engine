/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-9/15:39
 * 项目名称: dfbp-fa-engine
 * 文件名称: MarketDataServiceImpl.java
 * 文件描述: @Description: 行情数据service
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.manage.service.impl;

import com.win.dfbp.val.manage.dao.MarketDataMapper;
import com.win.dfbp.val.manage.service.MarketDataService;
import com.win.dfbp.val.manage.util.ReadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * 包名称：com.win.dfbp.val.manage.service.impl
 * 类名称：MarketDataServiceImpl
 * 类描述：行情数据service
 * 创建人：@author zoujian
 * 创建时间：2019-10-9/15:39
 */
@Service
public class MarketDataServiceImpl implements MarketDataService {

    @Autowired
    private MarketDataMapper marketDataMapper;

    private String marketFilePath = "marketFile";
    public static void main(String[] args) {
        MarketDataServiceImpl service = new MarketDataServiceImpl();
        service.updateValMarket();
    }


    @Override
    public void updateValMarket() {
        String filePath = this.getClass().getResource("/").getPath();
        File file = new File(filePath + marketFilePath);
        if(file.isDirectory()){
            File[] tempList = file.listFiles();
            for (int i = 0; i < tempList.length; i++) {
                // 解析中证行情数据txt文件
                if (tempList[i].isFile() && tempList[i].getName().endsWith(".txt")) {
                    //文件名，不包含路径
                    String fileName = tempList[i].getName();
                    List list = ReadFileUtil.readTxt(filePath + marketFilePath + "/" + fileName);
                    // 分批插入数据
                    int insertLength = list.size();
                    int k = 0;
                    while (insertLength > 2000) {
                        marketDataMapper.insertList(list.subList(k, k + 2000));
                        k = k + 2000;
                        insertLength = insertLength - 2000;
                    }
                    if (insertLength > 0) {
                        marketDataMapper.insertList(list.subList(k, k + insertLength));
                    }
                }
                // 解析中债行情数据dbf文件
                if (tempList[i].isFile() && tempList[i].getName().endsWith(".dbf")) {
                    //文件名，不包含路径
                    String fileName = tempList[i].getName();
                }
            }
        }
    }
}
