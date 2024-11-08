<template>
    <div>
        <h5>손자컴포넌트</h5>
        <p>{{ myMsg }}</p>
        <input type="text" v-model="name">
        <p>신청 이름 {{ name }}</p>
        <button @click="updateName">개명신청</button>
    </div>
</template>

<script setup>
    import { ref } from 'vue';

    defineProps({
        myMsg: String,
    });

    const emit = defineEmits(['updateName'])
    const updateName = () => {
        emit('updateName', name.value);
        name.value = "";
    }

    const name = ref("");
</script>

<style scoped>

</style>