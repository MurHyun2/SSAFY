<template>
  <div>
    <h4>자식 컴포넌트</h4>
    <p>{{ myMsg }}</p>
    <p v-text="myMsg"></p>
    <p>{{ dynamicName }}</p>
    <p>{{ person }}</p>
    <hr />
    <button @click="$emit('someEvent')">부모전송</button>
    <button @click="buttonClick">부모전송2</button>
    <button @click="emitArgs">추가인자전달</button>
    <hr />
    <ParentChildGrand @update-name="updateName" :my-msg="myMsg" />
  </div>
</template>

<script setup>
//부모로부터 받은 props를 사용하기 위한 방법은 크게 2가지
// defineProps(['myMsg']); // 심플한 받기
// 적어도 타입정도는 알려줘, 더 자세히 써주면 좋고...
const props = defineProps({
  myMsg: String,
  dynamicName: String,
  person: Object,
});

import ParentChildGrand from "./ParentChildGrand.vue";

const emit = defineEmits(["someEvent", "emitArgs", "updateName"]);

// 복잡한 경우에는 메서드로 빼서 쓰는 것이 가독성이 좋다!
const buttonClick = () => {
  emit("someEvent");
};

const emitArgs = () => {
  emit("emitArgs", 1, 2, 3);
};

const updateName = (name) => {
    emit('updateName', name);
};
</script>

<style scoped></style>
