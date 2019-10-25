import AxiosFun from "win-biz";

export default class CommonService {
    /**
     * 不传参获取所有估值分类基本信息
     */
    public static getAllValClassList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/class/list",
            null
        );
    }

    /**
     * 不传参获取所有估值方法基本信息
     */
    public static getAllMethodList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/method/list",
            null
        );
    }

    /**
     * 不传参获取所有产品状态信息
     */
    public static getAllFundStatusList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/fund/status/list",
            null
        );
    }

    /**
     * 不传参获取所有产品性质信息
     */
    public static getAllFundCharacterList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/fund/character/list",
            null
        );
    }
    /**
     * 不传参获取所有参数
     */
    public static getAllParamList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/param/list",
            null
        );
    }

    /**
     * 不传参获取所有参数方法
     */
    public static getAllParamMethodList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/param/method/list",
            null
        );
    }

    /**
     * 不传参获取所有参数方法
     */
    public static getAllFundList() {
        return AxiosFun.post(
            AxiosFun.valuationManageServiceName + "/fund/configure/all",
            null
        );
    }
}
