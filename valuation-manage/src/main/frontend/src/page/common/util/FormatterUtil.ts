import { CompareVO } from "../vo/CompareVO";
import ClassMethodConfigure from "../../valuation/fundConfigure/vo/ClassMethodConfigure";

export default class FormatterUtil {
    /**
     * 估值分类转换
     * @param cellValue
     */
    public classFormatter({ cellValue }) {
        const classList = CompareVO.classList;
        for (const valclass of classList) {
            if (cellValue === valclass.classCode) {
                return valclass.className;
            }
        }
        return "";
    }

    /**
     * 计算方式转化
     * @param param0
     */
    public typeFormatter({ cellValue }) {
        if (cellValue === 1) {
            return "计算公式";
        } else if (cellValue === 2) {
            return "计算模型";
        } else {
            return "未知类型";
        }
    }

    /**
     * 估值方法转换
     * @param cellValue
     */
    public methodFormatter({ cellValue }) {
        const methodList = CompareVO.methodList;
        for (const method of methodList) {
            if (cellValue === method.methodCode) {
                return method.methodName;
            }
        }
        return "";
    }

    /**
     * 估值参数转换
     * @param cellValue
     */
    public paramFormatter({ cellValue }) {
        const paramList = CompareVO.paramList;
        for (const param of paramList) {
            if (cellValue === param.paramCode) {
                return param.paramName;
            }
        }
        return "";
    }

    /**
     * 估值产品状态转换
     * @param cellValue
     */
    public fundStatusFormatter({ cellValue }) {
        const statusList = CompareVO.statusList;
        for (const status of statusList) {
            if (cellValue === status.fundStatusCode) {
                return status.fundStatusName;
            }
        }
        return "";
    }

    /**
     * 估值产品性质转化转换
     * @param cellValue
     */
    public fundCharacterFormatter({ cellValue }) {
        const characterList = CompareVO.characterList;
        for (const character of characterList) {
            if (cellValue === character.fundCharacterCode) {
                return character.fundCharacterName;
            }
        }
        return "";
    }

    /**
     * 参数和方法转化
     * @param cellValue
     */
    public getClassFormatter1(cellValue) {
        return cellValue.row.classMethod.fairPriceName;
    }
    public getClassFormatter2(cellValue) {
        return cellValue.row.classMethod.positionCostName;
    }
    public getClassFormatter3(cellValue) {
        return cellValue.row.classMethod.positionMarketName;
    }
    public getClassFormatter4(cellValue) {
        return cellValue.row.classMethod.costPriceName;
    }
    public getClassFormatter5(cellValue) {
        return cellValue.row.classMethod.floatingProfitLossName;
    }
    public getParamMethodFormatter1(cellValue) {
        return cellValue.row.paramMethod.costSettlementName;
    }
    public getParamMethodFormatter2(cellValue) {
        return cellValue.row.paramMethod.costSettlementSortName;
    }
    public getParamMethodFormatter3(cellValue) {
        return cellValue.row.paramMethod.realInterestRateName;
    }
}
