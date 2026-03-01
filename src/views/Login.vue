<template>
  <el-card>
    <el-form @submit.prevent="onLogin" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="password" />
      </el-form-item>
      <el-button type="primary" native-type="submit">登录</el-button>
      <el-button @click="$router.push('/register')">注册</el-button>
    </el-form>
  </el-card>
</template>

<script setup>
import { ref } from 'vue';
import { getUser } from '../api/index';

const username = ref('');
const password = ref('');

const onLogin = async () => {
  const res = await getUser(username.value);
  if (res.data && res.data.password === password.value) {
    localStorage.setItem('user', JSON.stringify(res.data));
    window.location.href = '/dashboard';
  } else {
    alert('用户名或密码错误');
  }
};
</script>