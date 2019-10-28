/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/9/27/14:24
 * 项目名称: TestFlink
 * 文件名称: SecurityIndexState.java
 * 文件描述: @Description: 指标状态
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.engine.flink.state;

import com.win.dfbp.entity.BaseKey;
import com.win.dfbp.entity.SecurityIndex;
import com.win.dfbp.entity.SecurityIndexVO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 包名称：com.win.wl
 * 类名称：SecurityIndexState
 * 类描述：指标状态
 * 创建人：@author wanglei
 * 创建时间：2019/9/27/14:24
 */
@Data
public class SecurityIndexState extends BaseKey implements Serializable {
    private SecurityIndexVO indexVO;
    public SecurityIndexState clone(SecurityIndex securityIndex){
        this.setPro(securityIndex);
        SecurityIndexVO indexVO = new SecurityIndexVO();
        indexVO.setPro(securityIndex.getIndexVO());
        this.setIndexVO(indexVO);
        return this;
    }

    public SecurityIndex parse(){
        SecurityIndex index = new SecurityIndex();
        index.setPro(this);
        SecurityIndexVO indexVO = new SecurityIndexVO();
        indexVO.setPro(this.getIndexVO());
        index.setIndexVO(indexVO);
        return index;
    }
}
