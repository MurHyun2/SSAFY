<template>
  <div>
    <p>username : {{ userName }}</p>
    <RouterView />
  </div>
</template>

<script setup>
import { provide, ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const userName = ref(route.params.username);;


</script>

<style scoped>

</style>