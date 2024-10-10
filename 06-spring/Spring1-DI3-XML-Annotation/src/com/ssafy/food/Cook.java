package com.ssafy.food;

import org.springframework.beans.factory.annotation.Autowired;

public class Cook {
//	@Autowired
	private final Ingredient ingredient;

//	@Autowired
	/*
	 * 클래스에 생성자가 하나만 존재하면 자동으로 주입처리한다.
	 * @Autowired 없더라도..
	 */
	public Cook(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	/*
	 * // @Autowired public void setIngredient(Ingredient ingredient) {
	 * this.ingredient = ingredient; }
	 */

	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
}
