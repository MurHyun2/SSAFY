package com.ssafy.ws.day06.step3;


public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		Book book3 = new Book("35356", "분석설계2", "소나무", "jaen.kr", 35000, "SW 모델링2");
		Book mz1 = new Magazine("34567", "Java", "김나무", "jaen.kr", 20000, "1월 알고리즘", 2021, 1);
		
		BookManager bm = new BookManager();
		bm.add(book1);
		bm.add(book2);
		bm.add(book3);
		bm.add(mz1);
		
		System.out.println("****************도서 전체 목록****************");
		for (Book book : bm.getList()) {
			System.out.println(book);
		}
		
		System.out.println("****************일반 도서 목록****************");
		for (Book book : bm.getBooks()) {
			System.out.println(book);
		}
		
		System.out.println("****************잡지 목록****************");
		for (Magazine mz : bm.getMagazines()) {
			System.out.println(mz);
		}
		
		System.out.println("****************도서 제목 포함검색 : Java****************");
		for (Book book : bm.searchByTitle("Java")) {
			System.out.println(book);
		}
		System.out.println(bm.getTotalPrice());
		System.out.println(bm.getPriceAvg());
		
		bm.remove("35355");
		System.out.println("****************도서 전체 목록****************");
		for (Book book : bm.getList()) {
			System.out.println(book);
		}
	}
}
