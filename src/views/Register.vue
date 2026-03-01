<template>
  <el-card>
    <el-form @submit.prevent="onRegister" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="form.password" />
      </el-form-item>
      <el-form-item label="年龄">
        <el-input type="number" v-model="form.age" />
      </el-form-item>
      <el-form-item label="身高">
        <el-input type="number" v-model="form.height" />
      </el-form-item>
      <el-form-item label="体重">
        <el-input type="number" v-model="form.weight" />
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.gender">
          <el-option label="男" value="男"/>
          <el-option label="女" value="女"/>
        </el-select>
      </el-form-item>
      <el-form-item label="病史">
        <el-input v-model="form.medicalHistory" />
      </el-form-item>
      <el-form-item label="过敏史">
        <el-input v-model="form.allergyInfo" />
      </el-form-item>
      <el-button type="primary" native-type="submit">注册</el-button>
    </el-form>
  </el-card>
</template>

<script setup>
import { ref } from 'vue';
import { register } from '../api/index';

const form = ref({
  username: '',
  password: '',
  age: 0,
  height: 0,
  weight: 0,
  gender: '',
  medicalHistory: '',
  allergyInfo: ''
});

const onRegister = async () => {
  await register(form.value);
  alert('注册成功');
  window.location.href = '/';
};
</script>