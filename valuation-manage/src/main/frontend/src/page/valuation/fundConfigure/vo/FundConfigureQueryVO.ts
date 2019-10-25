import { BaseReqVO } from "../../../common/vo/BaseVO";
/**
 * 类描述：估值产品配置参数VO
 * 创建人：@author huhe
 * 创建时间：2019/10/17
 */
export default class FundConfigureQueryVO extends BaseReqVO {
    /**
     * 估值产品no
     */
    public fundNo: string;
    /**
     * 产品状态
     */
    public fundStatus: number;
    /**
     * 模糊查询产品list专用
     */
    public fundName: String;
}
