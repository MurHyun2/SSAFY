package com.ssafy.ws.day06.step3;

import java.util.Arrays;

public class BookManager {
	private int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;

	void add(Book book) {
		if (size < MAX_SIZE)
			books[size++] = book;
	}

	void remove(String isbn) {
//		Book[] newBooks = new Book[size];
//		for (int i = 0; i < size; i++) {
//			newBooks[i] = books[i];
//		}
//		
//		for (int i = 0; i < size; i++) {
//			if (books[i].getIsbn().equals(isbn)) {
//				for (int j = i; j < size - 1; j++) {
//					books[j] = newBooks[j + 1];
//				}
//				books[size - 1] = null;
//				break;
//			}
//		}
//		size--;
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				System.arraycopy(books, i + 1, books, i, size - i - 1);
				books[size - 1] = null;
				break;
			}
		}
		size--;
	}

	Book[] getList() {
		return Arrays.copyOf(books, size);
	}

	Book searchByIsbn(String isbn) {
		Book result = null;

		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn))
				result = books[i];
		}
		return result;
	}

	Book[] searchByTitle(String title) {
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title))
				idx++;
		}
		Book[] result = new Book[idx];

		idx = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title))
				result[idx++] = books[i];
		}
		return result;
	}

	Magazine[] getMagazines() {
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine)
				idx++;
		}
		Magazine[] result = new Magazine[idx];

		idx = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine)
				result[idx++] = (Magazine) books[i];
		}
		return result;
	}

	Book[] getBooks() {
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine))
				idx++;
		}
		Book[] result = new Book[idx];

		idx = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine))
				result[idx++] = books[i];
		}
		return result;
	}

	int getTotalPrice() {
		int result = 0;

		for (int i = 0; i < size; i++) {
			result += books[i].getPrice();
		}
		return result;
	}

	double getPriceAvg() {
		return (double) getTotalPrice() / size;
	}
}
