import AxiosFun from "win-biz";
import MethodQueryVO from "../vo/MethodQueryVO";
/**
 * 类描述：估值方法service
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */
export default class MethodtionService {
    /**
     * 分页查询估值方法列表
     */
    public methodList(methodQueryVO: MethodQueryVO) {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/valManage/method/list",
            methodQueryVO
        );
    }
}
