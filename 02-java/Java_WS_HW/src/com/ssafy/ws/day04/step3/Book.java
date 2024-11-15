package com.ssafy.ws.day04.step3;

/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		String result = String.format("%-5s | %-6s | %-3s | %-8s | %-5d | %-10s", isbn, title, author, publisher, price, desc);
		return result;
	}
}
