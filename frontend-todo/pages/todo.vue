<template>
 <div class="min-h-screen bg-gradient-to-br from-purple-100 via-blue-100 to-pink-100 flex flex-col items-center py-10">
  <div class="w-full max-w-xl min-h-[700px] bg-white rounded-2xl shadow-lg p-6">
 <div class="max-w-xl mx-auto py-10">
    <Navbar />
    <TodoInput @add="addTodo" />
    <div class="space-y-2 mt-4">
      <TodoItem
        v-for="todo in todos"
        :key="todo.id"
        :todo="todo"
        @toggle="toggleTodo"
        @delete="deleteTodo"
      />
    </div>
  </div>
  </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import Navbar from '@/components/Navbar.vue'
import TodoInput from '@/components/TodoInput.vue'
import TodoItem from '@/components/TodoItem.vue'
import { useNuxtApp } from '#app'

const { $axios } = useNuxtApp()
const todos = ref([])
const checkedTodosIds = ref([])  // checkedTodosIds를 ref로 선언

onMounted(async () => {
const res = await $axios.get('/todos')
todos.value = res.data
console.log(res.data);
})

const addTodo = async (content) => {
  try {
  await $axios.post('/todos/add', { content }) // API로 전송
  const res = await $axios.get('/todos')   // 다시 목록 갱신
  todos.value = res.data
} catch (err) {
  alert('추가 실패!')
  console.error(err)
}

}
const toggleTodo =  async (id) => {
  try {
  // API 호출하여 완료 여부를 토글
  await $axios.put(`/todos/toggle/${id}`);
  
  // 완료된 항목을 UI에서 업데이트
  const res = await $axios.get('/todos');
  todos.value = res.data;

  const todo = todos.value.find(todo => todo.id === id)
  if (todo && todo.completed === 'Y') {
    checkedTodosIds.value.push(id)  // 완료된 항목 ID 추가
    console.log("정주현");
    console.log(checkedTodosIds.value);
  } else {
    checkedTodosIds.value = checkedTodosIds.value.filter(todoId => todoId !== id)  // 완료되지 않은 항목 ID 제거
  }
} catch (err) {
  alert('완료 여부 토글 실패!');
  console.error(err);
}
}

const deleteTodo = async (id) => {
  const ok = confirm('정말로 삭제하시겠습니까?')
  if (!ok) return  // 아니오 누르면 중단
  try {
  await $axios.delete(`/todos/delete/${id}`);  // 단일 삭제로 변경

  // 체크박스 목록에서도 제거
  checkedTodosIds.value = checkedTodosIds.value.filter(todoId => todoId !== id)

  // 목록 새로고침
  const res = await $axios.get('/todos');
  todos.value = res.data;

  alert('삭제되었습니다.');
} catch (err) {
  alert('삭제 실패!');
  console.error(err);
}
}
</script>
