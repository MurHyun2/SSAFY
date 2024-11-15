package com.ssafy.ws.day02.step2;

import java.util.Arrays;

/**
 * 영화리스트를 배열로 관리하는 클래스
 * 
 * @author
 *
 */
public class MovieManager {
	private int MAX_SIZE = 100;

	private Movie[] movieList = new Movie[MAX_SIZE];

	int size = 0;

	public void add(Movie movie) {
		if (size < 100) {
			movieList[size++] = movie;
		}
	}

	public Movie[] getList() {
		return Arrays.copyOf(movieList, size);
	}

	public Movie searchByTitle(String title) {
		Movie result = new Movie();
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().equals(title)) {
				result = movieList[i];
			}
		}
		return result;
	}
}
