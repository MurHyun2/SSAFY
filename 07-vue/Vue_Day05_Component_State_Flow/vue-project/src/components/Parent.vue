<template>
    <div>
        <h3>부모 컴포넌트</h3>
        <ParentChild @some-event="someCallBack" @emit-args="getNumber" @update-name="updateName"
        my-msg="mssage" :dynamic-name="name" :person="person" /> 
    </div>
</template>

<script setup>
    import { ref } from 'vue';
    import ParentChild from './ParentChild.vue';

    const name = ref("Kim");
    const person = ref({
        name: "Yang",
        age: 45
    })

    const someCallBack = () => {
        console.log("어떠한 이벤트 발생!");
    }

    const getNumber = (...args) => {
        console.log(args);
        console.log(`ParentChild가 전달한 추가인자 ${args}를 수신했어요`)
    }

    const updateName = (val) => {
        name.value = val;
    }

</script>

<style scoped>

</style>