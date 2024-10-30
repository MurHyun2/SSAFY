const member = {
  id: "ssafy",
  name: "김싸피",
  age: 22
};

// let id = member.id;
// let name = member.name;
// let age = member.age;

// let {id} = member;
// let {name} = member;
// let {age} = member;

let { age, name } = member;

console.log(age, name);

/////////////////////////////////

const arr = [10, 20, 30, 40];
let [a, b, c] = arr;

console.log(a, b, c);