<template>
    <div class="query-form">
        <win-form :inline="true" ref="queryForm">
            <div>
                <win-form-item label="" prop="valMethod">
                    <win-input clearable v-model="reqVO.valMethod" placeholder="请输入查询条件" @input="list()">
                    </win-input>
                </win-form-item>
            </div>

            <win-row>
                <win-table :data="dataList" :show-selection="false" :show-index="false" max-height="580px">
                    <win-table-column prop="methodName" label="估算方法" min-width="150"></win-table-column>
                    <win-table-column prop="calFormulaStr" label="计算公式" min-width="150"></win-table-column>
                    <win-table-column prop="calType" label="计算类型" :formatter="formatterUtil.typeFormatter" min-width="150"></win-table-column>
                    <win-table-column prop="valClass" label="估值分类" :formatter="formatterUtil.classFormatter" min-width="150"></win-table-column>
                </win-table>
            </win-row>
            <!-- 分页组件 -->
            <win-pagination v-bind:pageInfo="pageVO" @pageInfoChange="pageQuery"></win-pagination>
        </win-form>
    </div>
</template>

<script lang="ts">
import MethodController from "../controller/MethodController";
export default class Method extends MethodController {}
</script>

<style lang="scss" scoped>
@import "../../../../assets/style/page.scss";
.icon1 {
    color: #f3890e;
    margin-right: 8px;
}
</style>

