<template>
    <div class="newBondInst">
        <el-container>
            <el-aside class="left">
                <div class="fare">
                    <win-tabs class="second-tabs" v-model="activeName" tab-position="left">
                        <win-tab-pane label="计算项" name="calculation">
                        </win-tab-pane>
                        <win-tab-pane label="估值方法" name="method">
                        </win-tab-pane>
                        <win-tab-pane label="产品估值配置" name="fundConfigure">
                        </win-tab-pane>
                    </win-tabs>
                </div>
            </el-aside>
            <el-main>
                <Calculation v-if="activeName === 'calculation'"></Calculation>
                <Method v-if="activeName === 'method'"></Method>
                <FundConfigure v-if="activeName === 'fundConfigure'"></FundConfigure>
            </el-main>
        </el-container>
    </div>
</template>
<script lang="ts">
import Component from "vue-class-component";

import ValuationController from "../controller/ValuationController";
export default class Valuation extends ValuationController {}
</script> 
<style lang="scss" scoped>
.left {
    width: 200px !important;
    height: 880px;
    background-color: #353f58;
}
.fare /deep/ {
    background-color: transparent;
    margin-top: 20px;
    .el-tabs--left .el-tabs__item.is-left {
        float: none !important;
        text-align: left;
        width: 199px;
        left: 1px;
        background: transparent !important;
        margin-left: -1px;
    }
    .el-tabs--left .el-tabs__header.is-left {
        float: left;
        margin-bottom: 0;
        margin-right: 10px;
        position: relative;
        left: 4px;
    }
    .el-tabs__item {
        border-right: 1px solid transparent !important;
    }
    .second-tabs .el-tabs__item.is-active {
        background: transparent !important;
        color: #ff900d !important;
        &::after {
            border-bottom: 1px solid transparent !important;
        }
    }
}
</style>