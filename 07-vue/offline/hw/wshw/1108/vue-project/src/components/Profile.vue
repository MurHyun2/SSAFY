<template>
    <div>
      <RouterLink :to="{name: 'user-profile', params: {username : userName}}">상세 프로필</RouterLink> |
      <RouterLink :to="{name: 'user-posts', params: {username : userName}}">작성한 게시글</RouterLink>
      <hr>

      <div v-if="isUserProfile">
        <h2>상세 프로필</h2>
        <p>반갑습니다. admin입니다.</p>
      </div>
      <RouterView />
    </div>
  </template>
  
  <script setup>
  import { computed, ref } from 'vue';
  import { useRoute } from 'vue-router';
  
  const route = useRoute();
  const userName = ref(route.params.username);

  const isUserProfile = computed(()=> route.name === 'user-profile');
  </script>
  
  <style scoped>
  /* 스타일을 여기에 추가하세요 */
  </style>
  