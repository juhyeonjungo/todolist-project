<template>
    <div class="flex justify-between items-center p-2 border rounded">
      <div>
        <input type="checkbox" :checked="todo.completed === 'Y'" @change="toggle" />
        <span :class="{ 'line-through text-gray-400': todo.completed === 'Y' }" class="ml-2">
          {{ todo.content }}
        </span>
      </div>
      <button @click="deleteItem" class="text-red-500 hover:text-red-700">🗑️</button>
    </div>
  </template>
  
  <script setup>
  const props = defineProps({
    todo: Object
  })
  const emit = defineEmits(['toggle', 'delete'])
  
  const toggle = () => emit('toggle', props.todo.id)
  const deleteItem = () => emit('delete', props.todo.id)
  </script>
  