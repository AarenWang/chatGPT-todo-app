<template>
  <div>
    <h1>Task Management App</h1>
    <form @submit.prevent="addTask">
      <label for="name">Task Name:</label>
      <input type="text" v-model="newTask.name" id="name" required>

      <label for="begin">Begin Time:</label>
      <datetime-picker v-model="newTask.beginTime" id="begin" required></datetime-picker>

      <label for="end">End Time:</label>
      <datetime-picker v-model="newTask.endTime" id="end" required></datetime-picker>

      <button type="submit">Add Task</button>
    </form>

    <TaskList :tasks="tasks" @update-task="updateTask" />

  </div>
</template>

<script>
import { reactive } from 'vue'
import axios from 'axios'
import DatetimePicker from 'vue3-datetime-picker'
import TaskList from '@/components/TaskList.vue'

export default {
  name: 'TaskManagementApp',
  components: {
    DatetimePicker,
    TaskList
  },
  setup() {
    const newTask = reactive({
      name: '',
      beginTime: '',
      endTime: '',
      completed: false
    })

    const tasks = reactive([])

    const addTask = async () => {
      try {
        const response = await axios.post('/api/tasks', newTask)
        tasks.push(response.data)
        newTask.name = ''
        newTask.beginTime = ''
        newTask.endTime = ''
      } catch (error) {
        console.error(error)
      }
    }

    const getTasks = async () => {
      try {
        const response = await axios.get('/api/tasks')
        tasks.push(...response.data)
      } catch (error) {
        console.error(error)
      }
    }

    const updateTask = async (task) => {
      try {
        const response = await axios.patch(`/api/tasks/${task.id}`, { completed: task.completed })
        task = response.data
      } catch (error) {
        console.error(error)
      }
    }

    getTasks()

    return { newTask, tasks, addTask, updateTask }
  }
}
</script>
