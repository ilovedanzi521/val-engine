/**
 * 类描述：估值方法配置VO
 * 创建人：@author huhe
 * 创建时间：2019/10/17
 */
export default class ClassMethodConfigure {
    /**
     * 公允价对应的method_code
     */
    public fairPrice: string;
    /**
     * 持仓成本对应的method_code
     */
    public positionCost: string;
    /**
     * 持仓市值对应的method_code
     */
    public positionMarket: string;
    /**
     * 成本价对应的method_code
     */
    public costPrice: string;
    /**
     * 浮动盈亏对应的method_code
     */
    public floatingProfitLoss: string;
    /**
     * 公允价对应的方法名称
     */
    public fairPriceName: string;
    /**
     * 持仓成本对应的方法名称
     */
    public positionCostName: string;
    /**
     * 持仓市值对应的方法名称
     */
    public positionMarketName: string;
    /**
     * 成本价对应的方法名称
     */
    public costPriceName: string;
    /**
     * 浮动盈亏对应的方法名称
     */
    public floatingProfitLossName: string;
}
