import { createRouter, createWebHistory } from 'vue-router';
import Login from '../views/Login.vue';
import Register from '../views/Register.vue';
import Dashboard from '../views/Dashboard.vue';
import FoodLog from '../views/FoodLog.vue';
import GoalManage from '../views/GoalManage.vue';
import AnalysisDetail from '../views/AnalysisDetail.vue';

const routes = [
  { path: '/', component: Login },
  { path: '/register', component: Register },
  { path: '/dashboard', component: Dashboard },
  { path: '/foodlog', component: FoodLog },
  { path: '/goal', component: GoalManage },
  { path: '/analysis/:id', component: AnalysisDetail, props: true }
];

export default createRouter({
  history: createWebHistory(),
  routes,
});