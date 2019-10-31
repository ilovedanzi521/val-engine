/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/12/13:35
 * 项目名称: dfbp-val-engine
 * 文件名称: FlinkKafKaConsumerTask.java
 * 文件描述: @Description: flink使用kafka消费消息的task任务
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.engine.flink;

import com.win.dfas.common.vo.SysRedisCacheReqVO;
import com.win.dfbp.val.core.entity.ValMarket;
import com.win.dfbp.val.engine.flink.transform.ValMarketFunction;
import com.win.dfbp.val.engine.service.depand.RedisCacheLoaderFeign;
import com.win.dfbp.val.engine.service.impl.MarketDataServiceImpl;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * 包名称：com.win.dfbp.engine.flink
 * 类名称：FlinkKafKaConsumerTask
 * 类描述：flink使用kafka消费消息的task任务
 * 创建人：@author wanglei
 * 创建时间：2019/10/12/13:35
 */
@Component
public class FlinkFileReadTask {
    @Autowired
    private MarketDataServiceImpl marketDataService;

    @Autowired
    private RedisCacheLoaderFeign redisCacheLoaderFeign;

    @Async(value = "flinkFileReadThread")
    public void run() {
        while (true) {
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
            // 解析获取行情文件数据
            List<ValMarket> list = marketDataService.getValMarketData();
            try {
                if(list != null && list.size() > 0){
                    // 1、解析文件读取到List集合中
                    DataSource<ValMarket> dataSource = env.fromCollection(list);
                    // 2、将List集合数据塞入Flink中
                    dataSource.flatMap(new ValMarketFunction()).print();
                    //            dataSource.flatMap(new ValMarketFunction()).map(new ValPositionFunction());
                    // 3、更新val_position表数据
                    //updateValPosition(collectorList);
                    // 4、强制库存刷新缓存
                    updatePositionCache();
                    // 5、删除目录下的文件
                    String filePath = this.getClass().getResource("/").getPath() + "marketFile";
                    clearFile(filePath);
                }
                Thread.sleep(1000 * 60 * 5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Flink 操作Mysql更新val_position
     * @Title: updateValPosition
     * @param list
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-19/16:44
     */
    private void updateValPosition(List list){


    }

    /**
     * 刷新库存val_position缓存
     * @Title: updatePositionCache
     * @param
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-21/11:43
     */
    private void updatePositionCache(){
        SysRedisCacheReqVO reqVO = new SysRedisCacheReqVO();
        reqVO.setCacheType("VAL_POSITION");
        reqVO.setKey("pk");
        redisCacheLoaderFeign.refreshCache(reqVO);
    }

    private void clearFile(String filePath){
        File file = new File(filePath );
        if(file.exists()) {
            File[] filePaths = file.listFiles();
            for(File f : filePaths) {
                if(f.isFile()) {
                    f.delete();
                }
                if(f.isDirectory()){
                    String fpath = f.getPath();
                    clearFile(fpath);
                }
            }
        }
    }
}
