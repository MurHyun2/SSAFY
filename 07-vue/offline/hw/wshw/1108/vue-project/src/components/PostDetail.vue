<template>
  <div>
    <hr>
    <div v-if="selectPost">
      <p>번호 : {{ selectPost.id }}</p>
      <p>제목 : {{ selectPost.title }}</p>
      <p>내용 : {{ selectPost.content }}</p>
    </div>
  </div>
</template>

<script setup>
import { computed, inject } from "vue";
import { useRoute } from "vue-router";

const posts = inject('posts');
const route = useRoute();

console.log(posts);

const selectPost = computed(() => 
  posts.find((post) => post.id === parseInt(route.params.id))
);

</script>

<style scoped></style>
