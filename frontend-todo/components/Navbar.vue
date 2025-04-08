<template>
     <div class="py-4">
    <h1 class="text-2xl font-bold text-center"> 📝 할 일 목록</h1> <!-- 제목 추가 -->
    <div class="flex justify-between items-center py-4 border-b">
      <span class="font-bold text-xl">👤 {{ username }}님 안녕하세요</span>
      <button @click="logout" class="text-red-500 hover:underline">로그아웃</button>
    </div>
  </div>
  </template>
  
  <script setup>
  import { useUserStore } from '@/stores/user'
  import { useRouter } from 'vue-router'
  
  const store = useUserStore()
  const router = useRouter()
  
  const username = store.username
  
  const logout = () => {
    store.logout()
    router.push('/')
  }
  </script>
  