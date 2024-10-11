package com.ssafy.food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		System.out.println("Container Object created");
		
		ApplicationContext container = new GenericXmlApplicationContext("food-config.xml");
		
		Cook cook = (Cook) container.getBean("cook");
		cook.display();
		
		System.out.println("END");
	}
}
