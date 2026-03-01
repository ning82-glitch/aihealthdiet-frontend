<template>
  <div>
    <h3>AI分析详情</h3>
    <el-descriptions :title="log.foodDescription" :column="1">
      <el-descriptions-item label="图片">
        <img :src="log.foodImageUrl" style="max-width:120px" />
      </el-descriptions-item>
      <el-descriptions-item label="分析结果">
        <div style="white-space: pre-line;">{{ log.nutritionResult }}</div>
      </el-descriptions-item>
      <el-descriptions-item label="时间">{{ log.timestamp }}</el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script setup>
defineProps({ log: Object });
</script>