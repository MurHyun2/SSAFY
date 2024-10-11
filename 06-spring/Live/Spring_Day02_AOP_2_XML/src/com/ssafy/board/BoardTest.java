package com.ssafy.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.board.controller.BoardController;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext container = new GenericXmlApplicationContext("board-config.xml");
		BoardController bCon = container.getBean("boardController", BoardController.class);
		bCon.addBoard("AOP 성공");
	}
}
