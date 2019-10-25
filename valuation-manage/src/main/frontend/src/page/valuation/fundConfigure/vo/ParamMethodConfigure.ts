/**
 * 类描述：估值参数配置VO
 * 创建人：@author huhe
 * 创建时间：2019/10/17
 */
export default class ParamMethodConfigure {
    /**
     * 成本结算对应的method_code
     */
    public costSettlement: string;
    /**
     * 成本核算顺序对应的method_code
     */
    public costSettlementSort: string;
    /**
     * 实际利率对应的method_code
     */
    public realInterestRate: string;
    /**
     * 成本结算对应的方法名称
     */
    public costSettlementName: string;
    /**
     * 成本核算顺序对应的方法名称
     */
    public costSettlementSortName: string;
    /**
     * 实际利率对应的方法名称
     */
    public realInterestRateName: string;
}
