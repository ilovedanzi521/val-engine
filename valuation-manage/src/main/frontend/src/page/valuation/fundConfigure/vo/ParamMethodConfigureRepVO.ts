import { BaseRepVO } from "../../../common/vo/BaseVO";
import ParamMethodConfigure from "./ParamMethodConfigure";
import ClassMethodConfigure from "./ClassMethodConfigure";

/**
 * 类描述：估值方法VO
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */
export default class ParamMethodConfigureRepVO extends BaseRepVO {
    /**
     * 参数code
     */
    public paramCode: string;
    /**
     * 参数名称
     */
    public paramName: string;
    /**
     * 参数方法code
     */
    public methodCode: string;
    /**
     * 参数方法名称
     */

    public methodName: string;
}
