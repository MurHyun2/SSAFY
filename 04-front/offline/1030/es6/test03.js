function fn1(num) {
  return num * num;
}

const fn1_a = num => num * num;

const fn1_b = num => {
  console.log(num);
  return num * num;
}

console.log(fn1_b(10));