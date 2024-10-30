function fn2(msg) {}

const fn2_a = (msg) => {};
// 파라미터가 하나일 경우 소괄호 생략 가능
const fn2_b = msg => {};

function fn1(name, msg) {
  console.log(name + ", " + msg);
}

const fn2 = (name, msg) => console.log(name + ", " + msg);

fn1("이름 1", "메세지 1");
fn2("이름 2", "메세지 2");