<template>
  <div>
    <header>
      <div>
        <h1>명함 관리 페이지</h1>
      </div>
    </header>
    <main>
      <article>
        <p>명함을 관리하는 페이지입니다. 여기에 명함 목록이 표시됩니다.</p>
      </article>
      <article>
        <CreateForm @createCardEvent="updateCard" />
        <BusinessCard :new-card="newCard"/>
      </article>
    </main>
  </div>
  <footer>
    <p>©️ 2023 My Business Cards</p>
  </footer>
</template>

<script setup>
import { ref } from "vue";
import BusinessCard from "./components/businessCard.vue";
import CreateForm from "./components/createForm.vue";

const newCard = ref({});

const updateCard = (cardInfo) => {
  newCard.value= cardInfo.value;
}

</script>

<style>
#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  > div {
    justify-self: center;
  }
}

main {
  flex: 1;
}

footer {
  margin-top: auto;
  background-color: #ccc;
  width: 100%;
}

footer p {
  text-align: center;
  font-size: 16px;
}

header {
  justify-self: center;
  margin-bottom: 50px;
  > div {
    background-color: blue;
    color: white;
    display: inline-block;
    padding: 20px;
  }
}
article {
  text-align: center;
}

article:last-of-type {
  margin-top: 50px; /* 3칸 띄움 */
}
</style>
