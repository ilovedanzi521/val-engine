/****************************************************
 * 创建人: @author zoujian    
 * 创建时间: 2019-10-18/17:11
 * 项目名称: dfbp-fa-engine
 * 文件名称: MarketDataMapper.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.engine.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包名称：com.win.dfbp.engine.dao
 * 类名称：MarketDataMapper
 * 类描述：行情数据mapper
 * 创建人：@author zoujian
 * 创建时间：2019-10-18/17:11
 */
@Mapper
public interface MarketDataMapper {
    /**
     * 行情数据插入
     * @Title: insert
     * @param list
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-10/9:16
     */
    void insertList(List list);
}
