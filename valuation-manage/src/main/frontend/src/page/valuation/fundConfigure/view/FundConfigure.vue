<template>
    <div class="query-form">
        <win-form :inline="true" ref="queryForm">
            <div>
                <win-form-item label="产品名称">
                    <win-select clearable v-model="reqVO.fundNo" placeholder="代码名称模糊搜索">
                        <win-option v-for="item in compareVO.fundList" :key="item.fundNo" :label="item.fundName" :value="item.fundNo">
                            <span>{{item.fundName}}</span>
                        </win-option>
                    </win-select>
                </win-form-item>
                <win-form-item label="产品状态" prop="status">
                    <win-select clearable v-model="reqVO.fundStatus">
                        <win-option label="正常" value="1"> </win-option>
                        <win-option label="注销" value="2"> </win-option>
                    </win-select>
                </win-form-item>
                <win-form-item>
                    <div class="form-button">
                        <win-button @click="list()" type="primary">查询</win-button>
                        <win-button @click="reset()" type="default">重置</win-button>
                    </div>
                </win-form-item>
            </div>

            <win-row>
                <win-table :data="dataList" :show-selection="false" :show-index="false" max-height="580px">
                    <win-table-column prop="fundNo" label="产品代码" min-width="60"></win-table-column>
                    <win-table-column prop="fundName" label="产品名称" min-width="60"></win-table-column>
                    <win-table-column prop="characterName" label="产品性质" min-width="60"></win-table-column>
                    <win-table-column prop="fundStatusName" label="产品状态" min-width="60"></win-table-column>
                    <win-table-column prop="classMethod1" label="公允价" :formatter="formatterUtil.getClassFormatter1"></win-table-column>
                    <win-table-column prop="classMethod2" label="持仓成本" :formatter="formatterUtil.getClassFormatter2"></win-table-column>
                    <win-table-column prop="classMethod3" label="持仓市值" :formatter="formatterUtil.getClassFormatter3"></win-table-column>
                    <win-table-column prop="classMethod4" label="成本价" :formatter="formatterUtil.getClassFormatter4"></win-table-column>
                    <win-table-column prop="classMethod5" label="浮动盈亏" :formatter="formatterUtil.getClassFormatter5"></win-table-column>
                    <win-table-column prop="paramMethod1" label="成本结算" :formatter="formatterUtil.getParamMethodFormatter1"></win-table-column>
                    <win-table-column prop="paramMethod2" label="成本核算顺序" :formatter="formatterUtil.getParamMethodFormatter2"></win-table-column>
                    <win-table-column prop="paramMethod3" label="实际利率" :formatter="formatterUtil.getParamMethodFormatter3"></win-table-column>
                    <win-table-column width="10%" label="操作" fixed="right">
                        <template slot-scope="scope">
                            <div class="operate">
                                <span class="font-blue" @click="operation(scope.row)">修改</span>
                            </div>
                        </template>
                    </win-table-column>
                </win-table>
            </win-row>
            <!-- 分页组件 -->
            <win-pagination v-bind:pageInfo="pageVO" @pageInfoChange="pageQuery"></win-pagination>
            <FundConfigureDialog v-if="dialogVO.visible" :dialogVO="dialogVO" :fund="fund" :compareVO="compareVO" :paramMethodList="paramMethodList" :classMethodList="classMethodList"  @callFatherQuery="list">
            </FundConfigureDialog>
        </win-form>
    </div>
</template>

<script lang="ts">
import FundConfigureController from "../controller/FundConfigureController";
export default class FundConfigure extends FundConfigureController {}
</script>

<style lang="scss" scoped>
@import "../../../../assets/style/page.scss";
.icon1 {
    color: #f3890e;
    margin-right: 8px;
}
</style>

