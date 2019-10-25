import BaseController from "../../../common/controller/BaseController";
import { Component, Prop, Emit, Watch } from "vue-property-decorator";
import PageVO from "../../../common/vo/PageVO";
import { WinRspType } from "../../../common/enum/BaseEnum";
import CalculationService from "../service/CalculationService";
import CalculationQueryVO from "../vo/CalculationQueryVO";
import CalculationRepVO from "../vo/CalculationRepVO";

@Component({ components: {} })
export default class CalculationController extends BaseController {
    /** 资金服务类 */
    public calculationService: CalculationService = new CalculationService();
    /** 查询请求VO */
    public reqVO: CalculationQueryVO = new CalculationQueryVO();
    /** 表格数据 */
    public dataList: CalculationRepVO[] = [];
    /** 首次加载 */
    public mounted() {
        this.list();
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
        this.calculationService.calculationList(this.reqVO).then((res: any) => {
            if (res.winRspType === WinRspType.ERROR) {
                this.win_message_error(res.msg);
            } else {
                this.pageVO = res.data;
                this.dataList = this.pageVO.list;
            }
        });
    }

    /**
   

    /**
     * 重置查询
     */
    protected reset() {
        this.reqVO = new CalculationQueryVO();
        this.list();
    }
}
