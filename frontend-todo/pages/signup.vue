<template>
    <div class="min-h-screen flex items-center justify-center bg-gray-100">
      <div class="bg-white shadow-lg rounded-xl p-8 w-full max-w-sm">
        <h1 class="text-3xl font-bold text-center text-gray-800 mb-8">회원가입</h1>
        <form @submit.prevent="handleSignup" class="space-y-4">
          <input v-model="username" type="text" placeholder="아이디" class="input-style" />
          <input v-model="password" type="password" placeholder="비밀번호" class="input-style" />
          <input v-model="email" type="email" placeholder="이메일" class="input-style" />
          <input v-model="address" type="text" placeholder="주소" class="input-style" />
          <input v-model="phone" type="text" placeholder="전화번호" class="input-style" />
  
          <button type="submit" class="btn-style">회원가입</button>
        </form>
        <p class="text-sm text-center mt-4">
          이미 계정이 있으신가요?
          <NuxtLink to="/" class="text-blue-600 hover:underline">로그인</NuxtLink>
        </p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  const { $axios } = useNuxtApp()
  const router = useRouter()
  
  const username = ref('')
  const password = ref('')
  const email = ref('')
  const address = ref('')
  const phone = ref('')
  
  const handleSignup = async () => {
    try {
      await $axios.post('/user/signup', {
        username: username.value,
        password: password.value,
        email: email.value,
        address: address.value,
        phone: phone.value
      })
      alert('회원가입 성공!')
      router.push('/')
    } catch (err) {
      alert('회원가입 실패')
    }
  }
  </script>
  
  <style scoped>
  .input-style {
    @apply w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400;
  }
  .btn-style {
    @apply w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-600 transition;
  }
  </style>
  