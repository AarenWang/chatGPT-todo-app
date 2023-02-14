<template>
  <div id="app" class="todo">
    <h1>Todo List</h1>
    <TodoList />
  </div>
</template>

<script>
import TodoList from './components/TodoList.vue';
import './todo.css';

export default {
  name: 'App',
  components: {
    TodoList,
  },
};
</script>
