/****************************************************
 * 创建人: @author zoujian
 * 创建时间: 2019-10-19/13:41
 * 项目名称: dfbp-fa-engine
 * 文件名称: ValPositionService.java
 * 文件描述: @Description: 持仓信息Service
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.engine.service;

import java.util.List;

/**
 * 包名称：com.win.dfbp.engine.service
 * 类名称：ValPositionService
 * 类描述：持仓信息Service
 * 创建人：@author zoujian
 * 创建时间：2019-10-19/13:41
 */
public interface ValPositionService {
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
}
