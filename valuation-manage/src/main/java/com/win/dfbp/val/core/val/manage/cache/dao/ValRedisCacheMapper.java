/****************************************************
 * 创建人：     @author hechengcheng
 * 创建时间: 2019年7月31日/下午2:17:27
 * 项目名称：  dfbp-common-basicparameter
 * 文件名称: SysRedisCache.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfbp.val.core.val.manage.cache.dao;

import com.win.dfas.common.entity.SysRedisCache;
import com.win.dfas.common.vo.SysRedisCacheReqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 包名称： com.win.dfbp.basicparameter.dao
 * 类名称：SysRedisCache
 * 类描述：TODO
 * 创建人：@author hechengcheng
 * 创建时间：2019年7月31日/下午2:17:27
 *
 */
@Mapper
public interface ValRedisCacheMapper {

	/**
	 *
	 * 加载缓存定义列表
	 * @Title: list
	 * @param  reqVO
	 * @return: List<SysRedisCache>
	 * @throws
	 * @author: hechengcheng
	 * @Date:  2019年7月31日/下午2:29:08
	 */
	List<SysRedisCache> list(SysRedisCacheReqVO reqVO);


	/**
	 *
	 * 通过cacheSql加载缓存数据
	 * @Title: loadDataByCacheSql
	 * @param cacheSql
	 * @return
	 * @return: List<Map<String,Object>>
	 * @throws
	 * @author: hechengcheng
	 * @Date:  2019年7月31日/下午2:40:25
	 */
	List<Map<String, Object>> loadDataByCacheSql(@Param("cacheSql") String cacheSql);


	/**
	 * 更新缓存相关信息
	 * @Title: update
	 * @param reqVo
	 * @return: void
	 * @throws
	 * @author: wangzhen
	 * @Date:  2019/8/13/14:27
	 */
	void update(SysRedisCache reqVo);
}
