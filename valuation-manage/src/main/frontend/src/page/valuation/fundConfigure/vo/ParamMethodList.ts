import { BaseRepVO } from "../../../common/vo/BaseVO";
import ParamMethodConfigureRepVO from "./ParamMethodConfigureRepVO";

/**
 * 类描述：估值方法VO
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */
export default class ParamMethodList extends BaseRepVO {
    /**
     * 成本转结方法list
     */
    public costSettlements: ParamMethodConfigureRepVO[];
    /**
     * 成本核算顺序方法list
     */

    public costSettlementSorts: ParamMethodConfigureRepVO[];
    /**
    /**
     * 实际利率方法list
     */
    public realInterestRates: ParamMethodConfigureRepVO[];
}
