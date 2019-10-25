import AxiosFun from "win-biz";
import CalculationQueryVO from "../vo/CalculationQueryVO";
/**
 * 类描述：计算项service
 * 创建人：@author huhe
 * 创建时间：2019/10/09
 */
export default class CalculationService {
    /**
     * 分页查询产品资金列表
     */
    public calculationList(calculationQueryVO: CalculationQueryVO) {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/valCal/item/list",
            calculationQueryVO
        );
    }
}
