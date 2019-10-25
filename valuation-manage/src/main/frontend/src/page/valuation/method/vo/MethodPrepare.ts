import CompareInit from "../../../common/util/CompareInit";

const init = async () => {
    // 估值分类
    await CompareInit.initValClass();
};

/** 数据准备对象 */
export let MethodPrepare = {
    init
};
