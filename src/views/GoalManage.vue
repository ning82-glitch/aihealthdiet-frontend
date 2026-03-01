<template>
  <el-card>
    <h2>健康目标管理</h2>
    <el-form @submit.prevent="onAdd">
      <el-form-item label="目标类型">
        <el-select v-model="form.goalType">
          <el-option label="减脂" value="减脂"/>
          <el-option label="增肌" value="增肌"/>
          <el-option label="控糖" value="控糖"/>
          <el-option label="养胃" value="养胃"/>
        </el-select>
      </el-form-item>
      <el-form-item label="目标详情">
        <el-input v-model="form.goalDetail" />
      </el-form-item>
      <el-button type="primary" native-type="submit">添加目标</el-button>
    </el-form>
    <hr />
    <el-table :data="goals">
      <el-table-column prop="goalType" label="类型"/>
      <el-table-column prop="goalDetail" label="详情"/>
      <el-table-column prop="achieved" label="是否达成">
        <template #default="scope">
          <el-tag :type="scope.row.achieved ? 'success' : 'warning'">
            {{ scope.row.achieved ? '已达成' : '未达成' }}
          </el-tag>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { addGoal, getGoals } from '../api/index';

const user = ref({});
const form = ref({
  userId: 0,
  goalType: '',
  goalDetail: ''
});
const goals = ref([]);

onMounted(async () => {
  user.value = JSON.parse(localStorage.getItem('user') || '{}');
  form.value.userId = user.value.id;
  const res = await getGoals(user.value.id);
  goals.value = res.data;
});

const onAdd = async () => {
  await addGoal(form.value);
  alert('添加成功');
  const res = await getGoals(user.value.id);
  goals.value = res.data;
};
</script>