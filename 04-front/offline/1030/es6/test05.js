// function getMemberInfo() {
//   return {
//     id: "ssafy",
//     age: 22,
//     nickname: "김싸피"
//   };
// }

const getMemberInfo = () => ({id: "ssafy", age: 22, nickname: "김싸피"});

let {id, age, nickname} = getMemberInfo();

console.log(nickname);