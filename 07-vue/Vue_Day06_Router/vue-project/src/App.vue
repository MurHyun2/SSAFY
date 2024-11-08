<template>
  <div>
    <h2>App.Vue</h2>
    <nav>
      <RouterLink to="/">Home</RouterLink> |
      <RouterLink to="/about">about</RouterLink> |
      <RouterLink :to="{name: 'home'}">HomeName</RouterLink> |
      <RouterLink :to="{name: 'about'}">aboutName</RouterLink> |
      <RouterLink :to="{name: 'user', params: {id: 'dog'}}">강아지</RouterLink> |
      <RouterLink :to="{name: 'user', params: {id: 'cat'}}">고양이</RouterLink> |
      <RouterLink :to="{name: 'login'}">로그인</RouterLink> |
      <RouterLink :to="{name: 'board'}">게시글</RouterLink> |
    </nav>

    <RouterView />
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>