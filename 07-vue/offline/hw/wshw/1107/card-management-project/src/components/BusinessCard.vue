<template>
  <div>
    <BusinessCardDetail
      :business-cards="businessCards"
      @deleteCardEvent="deleteCard"
    />
  </div>
</template>

<script setup>
import { ref, watch } from "vue";
import BusinessCardDetail from "./BusinessCardDetail.vue";

const businessCards = ref([
  { name: "일론 머스크", title: "테슬라 테크노킹" },
  { name: "래리 엘리슨", title: "오라클 창업주" },
  { name: "빌 게이츠", title: "마이크로소프트 공동창업주" },
  { name: "래리 페이지", title: "구글 공동창업주" },
  { name: "세르게이 브린", title: "구글 공동창업주" },
]);

const deleteCard = (index) => {
  businessCards.value.splice(index, 1);
};

const props = defineProps(['newCard']);
watch(() => props.newCard, (card) => businessCards.value.push(card))
</script>

<style scoped></style>
