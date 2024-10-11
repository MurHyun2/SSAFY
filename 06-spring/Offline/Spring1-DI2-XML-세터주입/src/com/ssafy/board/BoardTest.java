package com.ssafy.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext container = new GenericXmlApplicationContext("board-config.xml");
		String[] names = container.getBeanDefinitionNames();
		
		for (String str : names) {
			System.out.println(str);
		}
		
		BoardController controller = container.getBean("boardController", BoardController.class);
		controller.addBoard("게시판 등록입니다.");
	}
}
