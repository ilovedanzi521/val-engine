/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/10/22/9:27
 * 项目名称: dfbp-val-engine
 * 文件名称: RedisSinkFunction.java
 * 文件描述: @Description: 结果写入redis缓存
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfbp.val.engine.flink.sink;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.util.RedisUtil;
import com.win.dfbp.val.common.constant.RedisKeyPrefix;
import com.win.dfbp.val.common.entity.SecurityIndex;
import com.win.dfbp.val.common.entity.SecurityIndexCash;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

/**
 * 包名称：com.win.dfbp.engine.flink.sink
 * 类名称：RedisSinkFunction
 * 类描述：结果写入redis缓存
 * 创建人：@author wanglei
 * 创建时间：2019/10/22/9:27
 */
@Slf4j
public class RedisSinkFunction extends RichSinkFunction<SecurityIndex> {

    @Override
    public void invoke(SecurityIndex securityIndex, Context context) throws Exception {
        //产品代码、组合代码、证券代码、交易市场、证券性质、投资标志
        //SELECT CONCAT(fund_no,fund_character,portf_no,security_code,market_code,platform_code,security_character,invest_flag,trade_direction) AS pk,
        //cash_settle_balance as cashSettleBalance,stock_settle_amount as stockSettleAmount,position_cost as positionCost,position_market_value as positionMarketValue,fair_price as fairPrice,cost_price as costPrice,floating_pl as floatingPL from val_position
        String key = securityIndex.key();
        try {
            SecurityIndexCash cash = securityIndex.parseSecurityIndexCash();
            RedisUtil.set(RedisKeyPrefix.VAL_POSITION + CommonConstants.HORIZONTAL_LINE + key,cash , -1);
            log.info("Data write redis cash Success! key:{}", RedisKeyPrefix.VAL_POSITION+ CommonConstants.HORIZONTAL_LINE +key);
        }catch (Throwable e){
            log.error("Redis缓存异常{}",e);
        }
    }
}

