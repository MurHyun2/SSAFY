package test05_overriding;

class Animal {
	public Animal() {
	}

	public void info() {
		System.out.println("Animal");
	}
}

class Dog extends Animal {
	public Dog() {
		System.out.println("Dog Dog");
	}
	public Dog(String name) {
		System.out.println(name);
	}
	public void info() {
		System.out.println("Dog");
	}
	public void bark() {
		super.info();
		System.out.println("Bark!");
	}
}

class Cat extends Animal {
	public void info() {
		System.out.println("Cat");
	}
	public void meow() {
		System.out.println("Meow!");
	}
}

public class Test11 {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.info();
		a = new Cat();
		a.info();
		
		Dog d = new Dog("강아지");
		
		d.info();
		d.bark();
		
		
	}
}
