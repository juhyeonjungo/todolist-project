<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-white shadow-lg rounded-xl p-8 w-full max-w-sm">
      <h1 class="text-3xl font-bold text-center text-gray-800 mb-8">로그인</h1>
      <form @submit.prevent="handleLogin" class="space-y-4">
        <input
          v-model="username"
          type="text"
          placeholder="아이디"
          class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
        <input
          v-model="password"
          type="password"
          placeholder="비밀번호"
          class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
        <button
          type="submit"
          class="w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-600 transition"
        >
          로그인
        </button>
      </form>
      <p class="text-sm text-center mt-4">
        계정이 없으신가요?
        <NuxtLink to="/signup" class="text-blue-600 hover:underline">회원가입</NuxtLink>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/user' // 스토어 경로 확인!
const router = useRouter()
const { $axios } = useNuxtApp()

const username = ref('')
const password = ref('')

const userStore = useUserStore()

const handleLogin = async () => {
  try {
    const res = await $axios.post('/user/login', {
      username: username.value,
      password: password.value
    })

    // token만 저장 (username은 v-model로 이미 있음)
    userStore.login(res.data.token, username.value)

    alert('로그인 성공!')
    router.push('/todo')
  } catch (err) {
    alert('로그인 실패!')
  }
}
</script>