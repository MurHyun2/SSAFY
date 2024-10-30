function fn1() {
  console.log("fn1");
}

const fn2 = function() {
  console.log("fn2");
}

const fn3 = () => console.log("fn3");

fn1();
fn2();
fn3();