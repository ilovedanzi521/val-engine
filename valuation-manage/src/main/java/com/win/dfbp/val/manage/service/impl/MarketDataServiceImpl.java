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
    /**
     * 每次循环插入数据的条数
     */
    private final Integer loopLength = 2000;

    @Override
    public void updateValMarket() {
        String marketFilePath = "marketFile";
        String integratedFilePathe = "integrated";
        String filePath = this.getClass().getResource("/").getPath();
        // 解析marketFile目录下的文件
        File file = new File(filePath + marketFilePath);
        if(file.isDirectory()){
            File[] tempList = file.listFiles();

            for (int i = 0; i < tempList.length; i++) {
                List list;
                // 解析中证行情数据txt文件
                if (tempList[i].isFile() && tempList[i].getName().endsWith(".txt")) {
                    //文件名，不包含路径
                    String fileName = tempList[i].getName();
                    list = ReadFileUtil.readTxt(filePath + marketFilePath + "/" + fileName);
                    insertBatches(list);

                }
                // 解析中债行情数据dbf文件
                if (tempList[i].isFile() && tempList[i].getName().endsWith(".dbf")) {
                    //文件名，不包含路径
                    String fileName = tempList[i].getName();
                    list = ReadFileUtil.readDbf(file.getPath() + "/" + fileName,false);
                    insertBatches(list);
                }
            }
        }
        // 解析integrated目录下的文件
        File file2 = new File(filePath + marketFilePath + "/"+ integratedFilePathe);
        if(file2.isDirectory()) {
            File[] tempList = file2.listFiles();
            for (int i = 0; i < tempList.length; i++) {
                List list;
                // 解析中债行情数据dbf文件
                if (tempList[i].isFile() && tempList[i].getName().endsWith(".dbf")) {
                    //文件名，不包含路径
                    String fileName = tempList[i].getName();
                    list = ReadFileUtil.readDbf(file2.getPath() + "/" + fileName,true);
                    insertBatches(list);
                }
            }
        }
    }

    /**
     * 分批数据插入
     * @Title: insertBatches
     * @param list
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-11/13:31
     */
    private void insertBatches(List list) {
        // 分批插入行情数据
        if(list != null){
            int insertLength = list.size();
            int k = 0;
            while (insertLength > loopLength) {
                marketDataMapper.insertList(list.subList(k, k + loopLength));
                k = k + loopLength;
                insertLength = insertLength - loopLength;
            }
            if (insertLength > 0) {
                marketDataMapper.insertList(list.subList(k, k + insertLength));
            }
        }
    }
}
