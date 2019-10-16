import Vue from "vue";
import { Component } from "vue-property-decorator";
/**Win插件开始 */
import {
    WinButton,
    WinForm,
    WinFormItem,
    WinInput,
    WinMenu,
    WinMenuItem,
    WinSubmenu,
    WinPagination,
    WinSelect,
    WinOption,
    WinSwitch,
    WinTable,
    WinTableColumn,
    WinTabs,
    WinTabPane,
    WinRow,
    WinCol,
    WinDatePicker,
    WinCheckbox,
    WinTree,
    WinAutocomplete,
    WinDivider,
    WinSelectTable,
    WinButtonGroup,
    WinFold
} from "win-plus";

/**Win插件结束 */
import { DicRepVO } from "win-biz";
import PageVO from "../vo/PageVO";
@Component({
    components: {
        WinButton,
        WinDatePicker,
        WinForm,
        WinFormItem,
        WinInput,
        WinMenu,
        WinMenuItem,
        WinSubmenu,
        WinPagination,
        WinSelect,
        WinOption,
        WinSwitch,
        WinTable,
        WinTableColumn,
        WinTabs,
        WinTabPane,
        WinRow,
        WinCol,
        WinCheckbox,
        WinTree,
        WinAutocomplete,
        WinDivider,
        WinSelectTable,
        WinButtonGroup,
        WinFold
    }
})
export default class BaseController extends Vue {
    pageVO: PageVO = new PageVO();
    /**字典值,表格显示 */
    dicFormatter(cellValue: string, dics: DicRepVO[]) {
        for (var i = 0; i < dics.length; i++) {
            if (cellValue === dics[i].dicCode) {
                return dics[i].dicExplain;
            }
        }
        return "";
    }

    /**对象复制 */
    copy(arr) {
        return JSON.parse(JSON.stringify(arr));
    }
}
