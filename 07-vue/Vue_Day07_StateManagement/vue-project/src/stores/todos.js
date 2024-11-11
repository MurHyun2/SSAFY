import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useTodosStore = defineStore("todos", () => {
  let id = 0; // 변할거야! 임시 변수

  //state
  const todos = ref([
    { id: id++, text: "잠자기", isDone: false },
    { id: id++, text: "밥먹기", isDone: false },
    { id: id++, text: "뷰 복습하기", isDone: false },
  ]);
  //action
  const addTodo = (todoText) => {
    todos.value.push({
      id: id++,
      text: todoText, //만약에 파라미터 명이 text 였다면 text: text인데 es6문법으로 text만 써도 가능
      isDone: false,
    });
  };

  const deleteTodo = (id) => {
    const idx = todos.value.findIndex((todo) => todo.id === id);
    todos.value.splice(idx, 1);
  };

  const updateTodo = (id) => {
    todos.value = todos.value.map((todo) => {
      if (todo.id == id) {
        todo.isDone = !todo.isDone;
      }

      return todo;
    });
  };

  //getters
  const doneTodoCount = computed(() => {
    return todos.value.filter((todo) => todo.isDone).length
  })

  return { todos, addTodo, deleteTodo, updateTodo, doneTodoCount };
}, {persist: true});
