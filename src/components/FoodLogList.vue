<template>
  <el-table :data="logs">
    <el-table-column prop="timestamp" label="时间"/>
    <el-table-column prop="foodDescription" label="描述"/>
    <el-table-column prop="foodImageUrl" label="图片">
      <template #default="scope">
        <img :src="scope.row.foodImageUrl" alt="食物图片" style="width: 80px;" />
      </template>
    </el-table-column>
    <el-table-column prop="nutritionResult" label="AI分析结果"/>
    <el-table-column label="分析详情">
      <template #default="scope">
        <el-button @click="$emit('analysis', scope.row)">详情</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue';
import { getFoodLogs } from '../api/index';

const props = defineProps({ userId: Number });
const logs = ref([]);

watch(() => props.userId, async (newVal) => {
  if (newVal) {
    const res = await getFoodLogs(newVal);
    logs.value = res.data;
  }
}, { immediate: true });
</script>