/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-19/13:45
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValPositionMapper.java
 * 文件描述: @Description: 持仓信息Mapper
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.engine.dao;

import com.win.dfbp.val.common.entity.SecurityIndex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包名称：com.win.dfbp.engine.dao
 * 类名称：ValPositionMapper
 * 类描述：持仓信息Mapper
 * 创建人：@author zoujian
 * 创建时间：2019-10-19/13:45
 */
@Mapper
public interface ValPositionMapper {
    /**
     * 批量更新持仓信息
     * @Title: batchUpdate
     * @param list
     * @return: void
     * @throws
     * @author: zoujian
     * @Date:  2019-10-19/13:44
     */
    void batchUpdate(List list);
    /**
     * @Title: insertValPosition
     * @Description merge insert_update操作
     * @param securityIndex
     * @return void
     * @throws
     * @author wanglei
     * @Date 2019/10/31/14:20
     */
    void insertValPosition(SecurityIndex securityIndex);
}
