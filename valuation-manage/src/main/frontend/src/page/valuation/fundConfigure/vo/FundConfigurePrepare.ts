import CompareInit from "../../../common/util/CompareInit";

const init = async () => {
    // 产品配置
    await CompareInit.initFundConfigure();
};

/** 数据准备对象 */
export let FundConfigurePrepare = {
    init
};
