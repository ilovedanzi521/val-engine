import BaseController from "../../../common/controller/BaseController";
import { Component, Prop, Emit, Watch } from "vue-property-decorator";
import PageVO from "../../../common/vo/PageVO";
import { WinRspType } from "../../../common/enum/BaseEnum";
import MethodService from "../service/MethodService";
import MethodQueryVO from "../vo/MethodQueryVO";
import MethodRepVO from "../vo/MethodRepVO";
import FormatterUtil from "../../../common/util/FormatterUtil";
import { MethodPrepare } from "../vo/MethodPrepare";

@Component({ components: {} })
export default class MethodController extends BaseController {
    /** 资金服务类 */
    public methodService: MethodService = new MethodService();
    /** 查询请求VO */
    public reqVO: MethodQueryVO = new MethodQueryVO();
    /** 表格数据 */
    public dataList: MethodRepVO[] = [];
    /**
     * 数据转化
     */
    public formatterUtil: FormatterUtil = new FormatterUtil();
    public mounted() {
        MethodPrepare.init();
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
        this.methodService.methodList(this.reqVO).then((res: any) => {
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
        this.reqVO = new MethodQueryVO();
        this.list();
    }
}
