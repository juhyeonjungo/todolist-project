// plugins/axios.js
import axios from 'axios'

export default defineNuxtPlugin(() => {
  const instance = axios.create({
    baseURL: 'http://localhost:8081/api', 
    withCredentials: true 
  })
  
 // 요청 보낼 때마다 토큰 자동으로 헤더에 붙이기
 instance.interceptors.request.use((config) => {
  const userStore = useUserStore()
  if (userStore.token) {
    config.headers.Authorization = `Bearer ${userStore.token}`
  }
  return config
})
  return {
    provide: {
      axios: instance
    }
  }
})
