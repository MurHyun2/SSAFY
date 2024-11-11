<template>
    <!-- 기록용 -->
    <div>
      <h2>StroeTest</h2>
      <!-- State 저장되어 있는 count 보고싶어 -->
      <p>state: {{ store.count }}</p>
      <!-- Getters 쓰고 싶어 -->
      <p>getter: {{ store.doubleCount }}</p>
      <button @click="store.increment()">증가1</button>
      <button @click="increment2">증가2</button>
    </div>
  </template>
  
  <script setup>
  import { useCounterStore } from "./stores/counter";
  
  const store = useCounterStore();
  
  console.log(store.count);
  
  const increment2 = () => {
    store.increment()
  }
  </script>
  
  <style scoped></style>
  