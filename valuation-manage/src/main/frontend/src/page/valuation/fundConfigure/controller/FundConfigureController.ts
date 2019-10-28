import BaseController from "../../../common/controller/BaseController";
import { Component, Prop, Emit, Watch } from "vue-property-decorator";
import PageVO from "../../../common/vo/PageVO";
import { WinRspType } from "../../../common/enum/BaseEnum";
import FundConfigureService from "../service/FundConfigureService";
import FundConfigureQueryVO from "../vo/FundConfigureQueryVO";
import FundConfigureRepVO from "../vo/FundConfigureRepVO";
import FormatterUtil from "../../../common/util/FormatterUtil";
import { FundConfigurePrepare } from "../vo/FundConfigurePrepare";
import { CompareVO } from "../../../common/vo/CompareVO";
import DialogVO from "../../../common/vo/DialogVO";
import FundConfigureDialog from "../view/FundConfigureDialog.vue";
import CompareInit from "../../../common/util/CompareInit";
import ParamMethodList from "../vo/ParamMethodList";
import ClassMethodList from "../vo/ClassMethodList";

@Component({ components: { FundConfigureDialog } })
export default class FundConfigureController extends BaseController {
    /** 资金服务类 */
    public fundConfigureService: FundConfigureService = new FundConfigureService();
    /** 查询请求VO */
    public reqVO: FundConfigureQueryVO = new FundConfigureQueryVO();
    public fund: FundConfigureRepVO = new FundConfigureRepVO();
    /** 表格数据 */
    public dataList: FundConfigureRepVO[] = [];
    /** 数据准备 */
    public compareVO = CompareVO;
    /** 对话框对象 */
    private dialogVO: DialogVO = new DialogVO();
    /**
     * 数据转化
     */
    public formatterUtil: FormatterUtil = new FormatterUtil();
    public paramMethodList: ParamMethodList = new ParamMethodList();
    public classMethodList: ClassMethodList = new ClassMethodList();

    public mounted() {
        this.list();
        FundConfigurePrepare.init();
    }

    /**
     * 普通查询，分页参数恢复默认
     */
    public list() {
        this.pageQuery(new PageVO());
    }

    /**
     * 分页查询列表，自带分页参数
     * @param pageVO 分页参数
     */
    public pageQuery(pageVO: PageVO) {
        this.reqVO.reqPageNum = pageVO.pageNum;
        this.reqVO.reqPageSize = pageVO.pageSize;
        this.fundConfigureService.fundList(this.reqVO).then((res: any) => {
            if (res.winRspType === WinRspType.ERROR) {
                this.win_message_error(res.msg);
            } else {
                this.pageVO = res.data;
                this.dataList = this.pageVO.list;
            }
        });
    }

    /**
     * 重置查询
     */
    protected reset() {
        this.reqVO = new FundConfigureQueryVO();
        this.list();
    }

    /** 打开修改弹框 */
    private operation(row: FundConfigureRepVO): void {
        this.dialogVO = this.dialogVO.getUpdateDialog(
            ParamBondRatingConst.UPDATE_BONDRATING
        );
        // 复制，创建对象副本
        this.fund = this.copy(row);
        //查询类型方法
        this.getMethodByClass();
        //查询参数方法
        this.getMethodByParam();

        // 产品性质
        CompareInit.initFundCharacter();
    }

    /**
     * 根据参数初始方法
     * @param paramCode
     */
    public getMethodByParam() {
        this.fundConfigureService.getMethodByParam().then((res: any) => {
            if (res.winRspType === WinRspType.ERROR) {
                this.win_message_error(res.msg);
            } else {
                this.paramMethodList = res.data;
            }
        });
    }
    /**
     * 根据参数初始方法
     * @param paramCode
     */
    public getMethodByClass() {
        this.fundConfigureService.getMethodByclass().then((res: any) => {
            if (res.winRspType === WinRspType.ERROR) {
                this.win_message_error(res.msg);
            } else {
                this.classMethodList = res.data;
            }
        });
    }
}

export const ParamBondRatingConst = {
    // 修改产品估值配置提示文本信息
    UPDATE_BONDRATING: "修改产品估值配置",
    //成本结算参数code
    COSTSETTLEMENT: "FP001",
    // 成本核算顺序对应的method_code
    COSTSETTLEMENTSORT: "FP002",
    // 实际利率对应的method_code
    REALINTERESTRATE: "FP003",
    // 持仓成本
    POSITIONCOST: "VC001",
    // 公允价
    FAIRPRICE: "VC002",
    // 持仓市值
    POSITIONMARKET: "VC003",
    // 成本价
    COSTPRICE: "VC004",
    // 浮动盈亏
    FLOATIONGPROFITLOSS: "VC005"
};
