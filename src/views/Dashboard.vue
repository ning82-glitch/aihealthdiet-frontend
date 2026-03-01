<template>
  <el-card>
    <h2>欢迎，{{ user.username }}</h2>
    <el-button @click="$router.push('/foodlog')">饮食日志</el-button>
    <el-button @click="$router.push('/goal')">健康目标</el-button>
  </el-card>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const user = ref({});
onMounted(() => {
  user.value = JSON.parse(localStorage.getItem('user') || '{}');
});
</script>