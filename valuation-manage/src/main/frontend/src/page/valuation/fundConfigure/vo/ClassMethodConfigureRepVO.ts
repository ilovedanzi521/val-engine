import { BaseReqVO } from "../../../common/vo/BaseVO";
/**
 * 类描述：根据类型查询方法配置的VO
 * 创建人：@author huhe
 * 创建时间：2019/10/17
 */
export default class ClassMethodConfigureReqVO {
    /**
     * 分类编码
     */
    public classCode: string;
    /**
     * 分类名称
     */
    public className: string;
    /**
     * 分类方法编码
     */
    public methodCode: string;
    /**
     * 参数方法名称
     */
    public methodName: string;
}
