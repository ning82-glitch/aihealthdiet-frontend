import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8081',
});

export function register(data) {
  return api.post('/user/register', data);
}

export function getUser(username) {
  return api.get(`/user/${username}`);
}

export function addFoodLog(data) {
  return api.post('/foodlog/add', data);
}

export function getFoodLogs(userId) {
  return api.get(`/foodlog/user/${userId}`);
}

export function addGoal(data) {
  return api.post('/goal/add', data);
}

export function getGoals(userId) {
  return api.get(`/goal/user/${userId}`);
}