import { BaseRepVO } from "../../../common/vo/BaseVO";
import ParamMethodConfigure from "./ParamMethodConfigure";
import ClassMethodConfigure from "./ClassMethodConfigure";

/**
 * 类描述：估值方法VO
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */
export default class FundConfigureRepVO extends BaseRepVO {
    /**
     * 产品code
     */
    public fundNo: string;
    /**
     * 产品名称
     */

    public fundName: string;
    /**
     * 产品状态编码
     */
    public fundStatusCode: string;
    /**
     * 产品性质编码
     */

    public fundCharacterCode: string;
    /**
     * 产品状态名称
     */
    public fundStatusName: string;
    /**
     * 产品性质名称
     */
    public characterName: string;
    /**
     * 关联方法配置
     */

    public classMethod: ClassMethodConfigure;
    /**
     * 关联参数配置
     */
    public paramMethod: ParamMethodConfigure;
}
