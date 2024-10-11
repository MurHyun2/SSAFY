package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		Programmer p = context.getBean("programmer", Programmer.class);
		Desktop desktop = (Desktop) context.getBean("desktop");
		
		p.setComputer(desktop);
		
		p.coding();
		
		Desktop d2 = context.getBean("desktop", desktop.getClass());
		
		System.out.println(desktop == d2); // 기본적으로 싱글턴으로 관리
	}
}
