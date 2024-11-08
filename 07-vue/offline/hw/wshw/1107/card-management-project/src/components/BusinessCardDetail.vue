<template>
  <div>
    <h1>보유 명함 목록</h1>
    <p v-if="businessCards.length > 0">현재 보유중인 명함 수 : {{ businessCards.length }}</p>
    <p v-else>명함이 없습니다. 새로운 명함을 추가해 주세요.</p>
    <ul class="business-cards">
      <template v-for="(card, index) in businessCards" :key="index">
        <li class="card">
          <div class="card-content">
            <h3 class="card-name">이름 : {{ card.name }}</h3>
            <p class="card-title">직함 : {{ card.title }}</p>
            <button @click="deleteCardFunc(index)">명함 삭제</button>
          </div>
        </li>
      </template>
    </ul>
  </div>
</template>

<script setup>
const props = defineProps({
  businessCards: {
    type: Array,
    required: true, // 필수 prop으로 설정
  },
});

const emit = defineEmits(["deleteCardEvent"]);

const deleteCardFunc = (index) => {
  emit("deleteCardEvent", index);
};
</script>

<style scoped>
/* 전체 카드 목록 스타일 */
.business-cards {
  list-style-type: none;
  padding: 0;
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
}

/* 각 카드 스타일 */
.card {
  background-color: #f5f5f5;
  padding: 20px;
  border: 1px solid black;
  width: 400px;
  text-align: center;
}

/* 카드 이름 스타일 */
.card-name {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 8px;
  word-wrap: break-word;
  line-height: 1.4;
}

/* 카드 타이틀 스타일 */
.card-title {
  font-size: 14px;
  color: #555;
  word-wrap: break-word;
  line-height: 1.4;
}
</style>
