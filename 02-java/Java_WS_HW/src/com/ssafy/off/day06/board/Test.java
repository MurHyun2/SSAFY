package com.ssafy.off.day06.board;

public class Test {
	public static void main(String[] args) {
		
	Board b1 = new Board(1, "첫번째 글", "홍길동1", "연습입니다. 1");
	Board b2 = new Board(2, "두번째 글", "홍길동2", "연습입니다. 2");
	Board b3 = new Board(3, "세번째 글", "홍길동3", "연습입니다. 3");
	Board b4 = new Board(4, "네번째 글", "홍길동4", "연습입니다. 4");
	
	BoardManager bm = BoardManager.getInstance();
	System.out.println(bm.add(b1));
	System.out.println(bm.add(b2));
	System.out.println(bm.add(b3));
	System.out.println(bm.add(b4));
	
	bm.modify(3, "수정된 세번째 글");
	
	for (Board board : bm.getBoards()) {
		System.out.println(board);
	}
	
	bm.delete(2);
	for (Board board : bm.getBoards()) {
		System.out.println(board);
	}
	
	System.out.println(bm.getBoard(1));
	
	}
}
