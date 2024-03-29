import AxiosFun from "win-biz";
import FundConfigureQueryVO from "../vo/FundConfigureQueryVO";
import FundConfigureRepVO from "../vo/FundConfigureRepVO";
/**
 * 类描述：估值方法配置service
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */
export default class FundConfiguretionService {
    /**
     * 分页查询估值方法配置列表
     */
    public fundList(fundConfigureQueryVO: FundConfigureQueryVO) {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/fund/configure/list",
            fundConfigureQueryVO
        );
    }

    public fundListByName(fundConfigureQueryVO: FundConfigureQueryVO) {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/fund/configure/name/list",
            fundConfigureQueryVO
        );
    }
    /**
     * 根据参数查询方法
     * @param queryVO
     */
    public getMethodByParam() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/param/configure/method",
            null
        );
    }

    /**
     * 修改
     * @param fundConfigureRepVO
     */
    public update(fundConfigureRepVO: FundConfigureRepVO) {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/fund/configure/update",
            fundConfigureRepVO
        );
    }

    /**
     * 根据class查询method
     * @param queryVO
     */
    public getMethodByclass() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/valManage/class/methods",
            null
        );
    }
}
