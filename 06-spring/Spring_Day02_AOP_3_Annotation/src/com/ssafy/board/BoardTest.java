package com.ssafy.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.board.controller.BoardController;
import com.ssafy.config.AopConfig;

public class BoardTest {
	public static void main(String[] args) {
//		ApplicationContext container = new GenericXmlApplicationContext("board-config.xml"); // xml + annotation
		ApplicationContext container = new AnnotationConfigApplicationContext(AopConfig.class);
		BoardController bCon = container.getBean("boardController", BoardController.class);
		bCon.addBoard("AOP 성공");
	}
}
