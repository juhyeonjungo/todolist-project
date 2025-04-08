<template>
    <form @submit.prevent="submit">
      <div class="flex">
        <input
          v-model="input"
          type="text"
          placeholder="할 일을 입력하세요"
          class="flex-1 px-4 py-2 border rounded-l"
        />
        <button type="submit" class="bg-blue-500 text-white px-4 rounded-r">추가</button>
      </div>
    </form>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  const emit = defineEmits(['add'])
  const input = ref('')
  
  const submit = () => {
    if (!input.value.trim()) return
    emit('add', input.value)
    input.value = ''
  }
  </script>
  