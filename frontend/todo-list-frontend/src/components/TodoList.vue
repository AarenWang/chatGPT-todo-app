<template>
  <div>
    <h1>Todo List</h1>
    <ul>
      <li v-for="todo in todos" :key="todo.id">
        {{ todo.title }}
        <button @click="deleteTodo(todo.id)">Delete</button>
      </li>
    </ul>
    <form @submit.prevent="addTodo">
      <input type="text" v-model="newTodoTitle" placeholder="New Todo" />
      <button type="submit">Add</button>
    </form>
  </div>
</template>

<script>
import TodoService from '../services/TodoService';

export default {
  data() {
    return {
      todos: [],
      newTodoTitle: ''
    };
  },
  mounted() {
    this.loadTodos();
  },
  methods: {
    loadTodos() {
      TodoService.getTodos()
        .then(response => {
          this.todos = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    addTodo() {
      TodoService.createTodo({
        title: this.newTodoTitle
      })
        .then(() => {
          this.newTodoTitle = '';
          this.loadTodos();
        })
        .catch(error => {
          console.error(error);
        });
    },
    deleteTodo(id) {
      TodoService.deleteTodo(id)
    }
  }
}
</script>
