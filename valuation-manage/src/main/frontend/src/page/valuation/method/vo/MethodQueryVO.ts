import { BaseReqVO } from "../../../common/vo/BaseVO";
/**
 * 类描述：估值方法参数VO
 * 创建人：@author huhe
 * 创建时间：2019/10/17
 */
export default class MethodQueryVO extends BaseReqVO {
    /**
     * 估值方法code
     */
    public valMethod: string;
}
