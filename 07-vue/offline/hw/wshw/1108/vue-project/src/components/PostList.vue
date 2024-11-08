<template>
  <div>
    <h4>{{ userName }}이 작성한 게시글</h4>
    <ul>
      <li v-for="post in posts" :key="post.id">
        <RouterLink :to="{ name: 'post-detail', params: { id: post.id } }"
          >제목:{{ post.title }}</RouterLink
        >
      </li>
    </ul>
    <RouterView />
  </div>
</template>

<script setup>
import { provide, ref } from "vue";
import { useRoute } from "vue-router";

const route = useRoute();
const userName = ref(route.params.username);

const posts = [
  { id: 1, title: "첫 번째 게시글", content: "첫 번째 게시글 내용입니다." },
  { id: 2, title: "두 번째 게시글", content: "두 번째 게시글 내용입니다." },
  { id: 3, title: "세 번째 게시글", content: "세 번째 게시글 내용입니다." },
];

provide("posts", posts);
</script>

<style scoped></style>
