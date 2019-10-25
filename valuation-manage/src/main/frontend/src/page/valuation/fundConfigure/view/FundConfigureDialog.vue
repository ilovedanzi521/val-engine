<template>
    <win-fdialog :title="dialogVO.title" :visible.sync="dialogVO.visible" width="1300px" :close-on-click-modal="dialogVO.closeOnClickModal" :before-close="closeFormDialog">
        <win-form :inline="true" label-width="130px" :model="fund" :rules="rules" :ref="formRefName" :disabled="dialogVO.disableFlag" v-testName="{'TEST_NAME':'FundConfigureDialog'}">
            <div class="hr">
                <win-row>
                    <win-col :span="spanWidth">
                        <win-form-item label="产品代码" prop="fundNo">
                            <win-input v-model="fund.fundNo" disabled></win-input>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="产品名称" prop="fundName">
                            <win-input v-model="fund.fundName" disabled></win-input>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="产品状态" prop="fundStatusName">
                            <win-input v-model="fund.fundStatusName" disabled></win-input>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="产品性质" prop="fundCharacterCode">
                            <win-select v-model="fund.fundCharacterCode" placeholder="请选择">
                                <win-option v-for="item in compareVO.characterList" :search="item.fundCharacterCode" :key="item.fundCharacterCode" :label="item.fundCharacterName" :value="item.fundCharacterCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                </win-row>
            </div>

            <div class="hr">
                <win-row>
                    <win-col :span="spanWidth">
                        <win-form-item label="公允价" prop="classMethod.fairPrice">
                            <win-select v-model="fund.classMethod.fairPrice" placeholder="请选择">
                                <win-option v-for="item in classMethodList1" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="持仓成本" prop="classMethod.positionCost">
                            <win-select v-model="fund.classMethod.positionCost" placeholder="请选择">
                                <win-option v-for="item in classMethodList2" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="持仓市值" prop="classMethod.positionMarket">
                            <win-select v-model="fund.classMethod.positionMarket" placeholder="请选择">
                                <win-option v-for="item in classMethodList3" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="成本价" prop="classMethod.costPrice">
                            <win-select v-model="fund.classMethod.costPrice" placeholder="请选择">
                                <win-option v-for="item in classMethodList4" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="浮动盈亏" prop="classMethod.floatingProfitLoss">
                            <win-select v-model="fund.classMethod.floatingProfitLoss" placeholder="请选择">
                                <win-option v-for="item in classMethodList5" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                </win-row>
            </div>
            <div class="hr">
                <win-row>
                    <win-col :span="spanWidth">
                        <win-form-item label="成本结转" prop="paramMethod.costSettlement">
                            <win-select v-model="fund.paramMethod.costSettlement" placeholder="请选择">
                                <win-option v-for="item in paramMethodList1" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="成本核算顺序" prop="paramMethod.costSettlementSort">
                            <win-select v-model="fund.paramMethod.costSettlementSort" placeholder="请选择">
                                <win-option v-for="item in paramMethodList2" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                    <win-col :span="spanWidth">
                        <win-form-item label="实际利率" prop="paramMethod.realInterestRate">
                            <win-select v-model="fund.paramMethod.realInterestRate" placeholder="请选择">
                                <win-option v-for="item in paramMethodList3" :search="item.methodCode" :key="item.methodCode" :label="item.methodName" :value="item.methodCode">
                                </win-option>
                            </win-select>
                        </win-form-item>
                    </win-col>
                </win-row>
            </div>
        </win-form>

        <div slot="footer" class="dialog-footer">
            <win-button @click="closeFormDialog" type="default">取消</win-button>
            <win-button @click="update" type="primary">确认</win-button>
        </div>
    </win-fdialog>
</template>
<script lang="ts">
import FundConfigureDialogController from "../controller/FundConfigureDialogController";
export default class FundConfigureDialog extends FundConfigureDialogController {}
</script>
<style lang="css" scoped>
.el-button--warning {
    background-color: #ff900d;
}
.el-date-editor {
    width: 224px;
}
.textarea /deep/ .el-textarea .el-textarea__inner {
    width: 950px;
}
</style>