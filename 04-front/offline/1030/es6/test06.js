const arr = [1, 10, 100];
console.log(...arr); // 1 10 100

const arr2 = [2, 20, 200, ...arr];
console.log(arr2); // [ 2, 20, 200, 1, 10, 100 ]

const obj1 = {id: "ssafy", age: 22};
const obj2 = {email: "hong@hong.com", ...obj1};
const obj3 = {...obj1, email: "hong@hong.com"};
console.log(obj2);
console.log(obj3);