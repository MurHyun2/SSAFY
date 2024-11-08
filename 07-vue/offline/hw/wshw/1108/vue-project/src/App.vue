<template>
  <div>
    <h2>App.vue</h2>
      <RouterLink :to="{name: 'home'}">Home</RouterLink> |
      <RouterLink :to="{name: 'about'}">About</RouterLink> |
      <RouterLink :to="{name: 'user', params: {username: 'admin'}}">User</RouterLink> |
      <RouterLink :to="{name: 'user-profile', params: {username: 'admin'}}">Admin</RouterLink> |

      <RouterView />
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>