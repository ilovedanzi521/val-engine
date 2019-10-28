import BaseController from "../../../common/controller/BaseController";
import { Component, Prop, Emit, Watch } from "vue-property-decorator";
import DialogVO from "../../../common/vo/DialogVO";
import FundConfigureRepVO from "../vo/FundConfigureRepVO";
import FundConfigureService from "../service/FundConfigureService";
import { CompareVO } from "../../../common/vo/CompareVO";
import ParamMethodConfigureRepVO from "../vo/ParamMethodConfigureRepVO";
import { WinRspType } from "../../../common/enum/BaseEnum";
import Method from "../../../common/vo/Method";
import ParamMethodList from "../vo/ParamMethodList";
import ClassMethodList from "../vo/ClassMethodList";

@Component({ components: {} })
export default class FundConfigureDialogController extends BaseController {
    [x: string]: any;
    /** 打开、编辑、删除弹出框VO */
    @Prop()
    public dialogVO: DialogVO;
    /** 数据准备 */
    @Prop()
    public compareVO = CompareVO;
   

    // span宽度
    private spanWidth: number = 8;
    /** form表单引用名称变量 */
    private formRefName: string = "forConfigForm";
    /** 编辑、保存对象 */
    @Prop()
    private fund: FundConfigureRepVO;

    /** 发送请求处理的service对象 */
    public fundConfigureService: FundConfigureService = new FundConfigureService();
    @Prop()
    public paramMethodList: ParamMethodList = new ParamMethodList();
    @Prop()
    public classMethodList: ClassMethodList = new ClassMethodList();

    /** 新增、修改，表单验证规则 */
    private rules = {
        fundCharacterCode: {
            required: true,
            message: FundConfigureDialogConst.FUNDCHARACTERCODE,
            trigger: "change"
        },
        "classMethod.fairPrice": {
            required: true,
            message: FundConfigureDialogConst.FAIRPRICE,
            trigger: "change"
        },
        "classMethod.positionCost": {
            required: true,
            message: FundConfigureDialogConst.POSITIONCOST,
            trigger: "change"
        },
        "classMethod.positionMarket": {
            required: true,
            message: FundConfigureDialogConst.POSITIONMARKET,
            trigger: "change"
        },
        "classMethod.costPrice": {
            required: true,
            message: FundConfigureDialogConst.COSTPRICE,
            trigger: "change"
        },
        "classMethod.floatingProfitLoss": {
            required: true,
            message: FundConfigureDialogConst.FLOATIONGPROFITLOSS,
            trigger: "change"
        },
        "paramMethod.costSettlement": {
            required: true,
            message: FundConfigureDialogConst.COSTSETTLEMENT,
            trigger: "change"
        },
        "paramMethod.costSettlementSort": {
            required: true,
            message: FundConfigureDialogConst.COSTSETTLEMENTSORT,
            trigger: "change"
        },
        "paramMethod.realInterestRate": {
            required: true,
            message: FundConfigureDialogConst.REALINTERESTRATE,
            trigger: "change"
        }
    };

    /** 修改 */
    private update(): void {
        const form: any = this.$refs[this.formRefName];
        form.validate(valid => {
            if (valid) {
                this.fundConfigureService.update(this.fund).then(res => {
                    this.commonResultHandling(res);
                });
            }
        });
    }

    /** 通用结果处理方法 */
    private commonResultHandling(res: any) {
        if (res.winRspType === WinRspType.SUCC) {
            this.closeFormDialog();
            this.successMessage(res.msg);
        } else if (res.winRspType === WinRspType.UNIQUE) {
            this.win_message_warning(res.msg);
        } else {
            this.errorMessage(res.msg);
        }
    }

    /** 关闭弹框 */
    private closeFormDialog(): void {
        const form: any = this.$refs[this.formRefName];
        if (form) {
            form.resetFields();
            form.clearValidate();
        }
        this.dialogVO.visible = false;
        this.$emit("callFatherQuery");
    }
}

export const FundConfigureDialogConst = {
    FUNDCHARACTERCODE: "产品性质不能为空",

    FAIRPRICE: "公允价不能为空",

    POSITIONCOST: "持仓成本不能为空",

    POSITIONMARKET: "持仓市值不能为空",

    COSTPRICE: "成本价不能为空",

    FLOATIONGPROFITLOSS: "浮动盈亏不能为空",

    COSTSETTLEMENT: "结算结转不能为空",

    COSTSETTLEMENTSORT: "成本核算顺序不能为空",

    REALINTERESTRATE: "实际利率不能为空"
};
