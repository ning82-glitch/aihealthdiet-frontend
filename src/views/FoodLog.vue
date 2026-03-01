<template>
  <el-card>
    <h2>添加饮食日志</h2>
    <el-form @submit.prevent="onAdd">
      <el-form-item label="食物图片URL">
        <el-input v-model="form.foodImageUrl" />
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="form.foodDescription" />
      </el-form-item>
      <el-button type="primary" native-type="submit">提交</el-button>
    </el-form>
    <hr />
    <FoodLogList :userId="user.id" @analysis="showAnalysis" />
    <el-dialog v-model="showDetail" width="600px" title="AI分析详情" :show-close="true">
      <AnalysisDetail v-if="currentLog" :log="currentLog" />
    </el-dialog>
  </el-card>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { addFoodLog } from '../api/index';
import FoodLogList from '../components/FoodLogList.vue';
import AnalysisDetail from './AnalysisDetail.vue';

const user = ref({});
const form = ref({
  userId: 0,
  foodImageUrl: '',
  foodDescription: '',
  timestamp: new Date().toISOString()
});
const showDetail = ref(false);
const currentLog = ref(null);

onMounted(() => {
  user.value = JSON.parse(localStorage.getItem('user') || '{}');
  form.value.userId = user.value.id;
});

const onAdd = async () => {
  await addFoodLog(form.value);
  alert('添加成功');
  window.location.reload();
};

const showAnalysis = (log) => {
  currentLog.value = log;
  showDetail.value = true;
};
</script>