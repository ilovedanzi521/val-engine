import ValClass from "./ValClass";
import Method from "./Method";
import ParamDictionary from "./Param";
import FundStatus from "./FundStatus";
import FundCharacter from "./FundCharacter";
import ParamMethod from "./ParamMethod";
import FundConfigure from "./FundConfigure";

export let CompareVO = {
    // 估值分类列表
    classList: new Array<ValClass>(),
    // 估值方法列表
    methodList: new Array<Method>(),
    // 估值参数字典列表
    paramList: new Array<ParamDictionary>(),
    // 估值产品状态列表
    statusList: new Array<FundStatus>(),
    // 估值产品性质列表
    characterList: new Array<FundCharacter>(),
    // 估值参数方法列表
    paramMethodList: new Array<ParamMethod>(),
    // 估值产品列表
    fundList: new Array<FundConfigure>()
};
