package live_test;

class Parent {}
class ChildA extends Parent {}
class ChildB extends Parent {}
class GrandChildA extends ChildA {}

public class CastTest {
	public static void main(String[] args) {
		// A 타입 = B타입
		// 묵시적(암묵적) 형변환
		// A(부모) = B(자식)
		
		// 명시적 형변환
		// A(자식) = (형변환) B(부모)
	}
}