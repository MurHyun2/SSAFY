package com.ssafy.food;

public class Cook {
	private Ingredient ingredient;
	
//	public Cook() {
//		System.out.println("Default Cook Constructor Called");
//	}

	public Cook(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
}
