import { BaseReqVO } from "../../../common/vo/BaseVO";
import ClassMethodConfigureReqVO from "./ClassMethodConfigureRepVO";
/**
 * 类描述：根据类型查询方法配置的VO
 * 创建人：@author huhe
 * 创建时间：2019/10/17
 */
export default class ClassMethodList {
    /**
     * 公允价方法list
     */
    public fairPrices: ClassMethodConfigureReqVO[];
    /**
     * 持仓成本方法list
     */
    public positionCosts: ClassMethodConfigureReqVO[];
    /**
     * 持仓市值方法list
     */
    public positionMarkets: ClassMethodConfigureReqVO[];
    /**
     * 成本价方法list
     */
    public costPrices: ClassMethodConfigureReqVO[];
    /**
     * 浮动盈亏方法list
     */
    public floatingProfitLoss: ClassMethodConfigureReqVO[];
}
