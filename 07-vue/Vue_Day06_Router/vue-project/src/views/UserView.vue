<template>
  <div>
    <h3>UserView</h3>
    <!-- 아래와 같이 바로 접근이 되기는 하지만 권장하지 않음 -->
    <p>{{ $route.params.id }}</p>
    <!-- 아래의 방식으로 사용하는 것을 권장 -->
    <p>{{ userId }}</p>
    <p>{{ userId2 }}</p>
    <hr />
    <button @click="goHome">GOHOME</button>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";
import { onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();

const userId = ref(route.params.id);
const userId2 = ref(route.params.id);
watch(
  () => route.params.id,
  (newId) => {
    userId.value = newId
  }
);

const goHome = () => {
    //직접 URL 경로를 작성할 수 있음
    // router.push('/')
    // 이름으로 호출할 수도 있음
    // router.push({name: 'home'})
    router.replace({name: 'home'})
}

onBeforeRouteLeave(()=> {
    const answer = confirm("정말로 떠나나요?")
    return answer;
})

onBeforeRouteUpdate((to)=> {
    userId2.value = to.params.id
})
</script>

<style scoped></style>
