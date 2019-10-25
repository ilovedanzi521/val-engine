import { CompareVO } from "../vo/CompareVO";
import CommonService from "../service/commonService";

/**
 * 类描述：基础数据准备初始化工具类
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */

export default class CompareInit {
    /**
     * 初始化估值分类信息
     */
    public static initValClass() {
        if (CompareVO.classList.length === 0) {
            return CommonService.getAllValClassList().then((res: any) => {
                CompareVO.classList = res.data;
            });
        }
    }

    /**
     * 初始化估值方法信息
     */
    public static initMethod() {
        if (CompareVO.methodList.length === 0) {
            return CommonService.getAllMethodList().then((res: any) => {
                CompareVO.methodList = res.data;
            });
        }
    }

    /**
     * 初始化估值参数信息
     */
    public static initParam() {
        if (CompareVO.paramList.length === 0) {
            return CommonService.getAllParamList().then((res: any) => {
                CompareVO.paramList = res.data;
            });
        }
    }

    /**
     * 初始化估值产品状态信息
     */
    public static initFundStatus() {
        if (CompareVO.statusList.length === 0) {
            return CommonService.getAllFundStatusList().then((res: any) => {
                CompareVO.statusList = res.data;
            });
        }
    }

    /**
     * 初始化估值产品性质信息
     */
    public static initFundCharacter() {
        if (CompareVO.characterList.length === 0) {
            return CommonService.getAllFundCharacterList().then((res: any) => {
                CompareVO.characterList = res.data;
            });
        }
    }

    /**
     * 初始化估值产品性质信息
     */
    public static initParamMethod() {
        if (CompareVO.paramMethodList.length === 0) {
            return CommonService.getAllParamMethodList().then((res: any) => {
                CompareVO.paramMethodList = res.data;
            });
        }
    }
    /**
     * 初始化估值产品性质信息
     */
    public static initFundConfigure() {
        if (CompareVO.fundList.length === 0) {
            return CommonService.getAllFundList().then((res: any) => {
                CompareVO.fundList = res.data;
            });
        }
    }
}
