import axios from 'axios';

const API_URL = 'http://localhost:8080/api/todos/';

export default {
  getTodos() {
    return axios.get(API_URL);
  },
  createTodo(todo) {
    return axios.post(API_URL, todo);
  },
  updateTodo(todo) {
    return axios.put(API_URL + todo.id, todo);
  },
  deleteTodo(id) {
    return axios.delete(API_URL + id);
  }
};
