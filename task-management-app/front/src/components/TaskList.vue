<template>
  <ul>
    <li v-for="task in tasks" :key="task.id">
      <input type="checkbox" v-model="task.completed" @change="updateTask(task)">
      <span :class="{ completed: task.completed }">{{ task.name }}</span>
    </li>
  </ul>
</template>

<script>
export default {
  name: 'TaskList',
  props: ['tasks', 'updateTask']
}
</script>

<style scoped>
.completed {
  text-decoration: line-through;
}
</style>
