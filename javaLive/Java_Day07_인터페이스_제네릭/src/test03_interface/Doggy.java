package test03_interface;

public class Doggy implements Dog{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		System.out.println("밥을 먹습니다");
		
		return "";
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("말을 합니다");
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("Bark");
	}

	@Override
	public void eat(String eat) {
		// TODO Auto-generated method stub
		
	}
	
}
