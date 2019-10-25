import BaseController from "../../../common/controller/BaseController";
import Calculation from "../../calculation/view/Calculation.vue";
import Method from "../../method/view/Method.vue";
import FundConfigure from "../../fundConfigure/view/FundConfigure.vue";
import { Component, Prop, Emit, Watch } from "vue-property-decorator";

@Component({ components: { Calculation, Method, FundConfigure } })
export default class ValuationController extends BaseController {
    protected activeName: string = "calculation";
}
