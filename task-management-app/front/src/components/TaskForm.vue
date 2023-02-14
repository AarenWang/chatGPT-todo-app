<template>
  <form @submit.prevent="addTask">
    <label for="name">Task Name:</label>
    <input type="text" v-model="newTask.name" id="name" required>
<label for="begin">Begin Time:</label>
<datetime-picker v-model="newTask.beginTime" id="begin" required></datetime-picker>

<label for="end">End Time:</label>
<datetime-picker v-model="newTask.endTime" id="end" required></datetime-picker>

<button type="submit">Add Task</button>
</form>
</template>

<script>
import { reactive } from 'vue'

export default {
name: 'TaskForm',
props: ['addTask'],
components: {
DatetimePicker
},
setup() {
const newTask = reactive({
  name: '',
  beginTime: '',
  endTime: '',
  completed: false
})

return { newTask }
}
}
</script>
