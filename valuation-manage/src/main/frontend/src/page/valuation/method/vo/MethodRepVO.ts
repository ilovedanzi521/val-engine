/**
 * 类描述：估值方法VO
 * 创建人：@author huhe
 * 创建时间：2019/10/18
 */
export default class MethodRepVO {
    /**
     * 估值分类
     */
    public valClass: string;
    /**
     * 估值方法
     */
    public valMethod: string;
    /**
     * 估值方法名称
     */
    public methodName: string;
    /**
     * 计算公式
     */
    public calFormula: string;
    /**
     * 计算公式名称
     */
    public calFormulaStr: string;
    /**
     * 计算类型 0-计算公式、1-计算模型
     */
    public calType: string;
}
