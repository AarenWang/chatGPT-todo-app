<template>
  <li>
    <input type="checkbox" v-model="completed" @change="updateTodo" />
    {{ todo.title }}
    <button @click="deleteTodo">Delete</button>
  </li>
</template>

<script>
import TodoService from '../services/TodoService';

export default {
  props: {
    todo: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      completed: this.todo.completed
    };
  },
  methods: {
    updateTodo() {
      TodoService.updateTodo({
        id: this.todo.id,
        title: this.todo.title,
        completed: this.completed
      })
        .then(() => {
          // Do something after updating the todo
        })
        .catch(error => {
          console.error(error);
        });
    },
    deleteTodo() {
      TodoService.deleteTodo(this.todo.id)
        .then(() => {
          // Do something after deleting the todo
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
};
</script>
