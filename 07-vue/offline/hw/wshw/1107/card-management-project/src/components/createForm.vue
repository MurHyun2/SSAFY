<template>
  <div>
    <form @submit.prevent="createCardFunc">
      <span> 이름 </span>
      <input type="text" v-model="name" />
      <span> 직함 </span>
      <input type="text" v-model="title" />
      <button>명함 추가</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";

const name = ref("");
const title = ref("");
const cardInfo = ref({});

const emit = defineEmits(["createCardEvent"]);

const createCardFunc = () => {
  cardInfo.value = { name: name.value, title: title.value };
  emit("createCardEvent", cardInfo);

  name.value = "";
  title.value = "";
};
</script>

<style scoped></style>
