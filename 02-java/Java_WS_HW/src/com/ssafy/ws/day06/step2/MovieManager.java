package com.ssafy.ws.day06.step2;

import java.util.Arrays;

/**
 * 영화리스트를 배열로 관리하는 클래스
 * @author 
 *
 */
public class MovieManager {
	private int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	
	public void add(Movie movie) {
		if(size < MAX_SIZE)
			movieList[size++] = movie;
	}
	
	public Movie[] getList() {
		return Arrays.copyOf(movieList, size);
	}
	
	public Movie[] getMovies() {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie))
				cnt++;
		}
		
		Movie[] result = new Movie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie))
				result[idx++] = movieList[i];
		}
		return result;
	}
	
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if(movieList[i] instanceof SeriesMovie)
				cnt++;
		}
		
		SeriesMovie[] result = new SeriesMovie[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if(movieList[i] instanceof SeriesMovie)
				result[idx++] = (SeriesMovie) movieList[i];
		}
		return result;
	}
	
	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		
		for (int i = 0; i < size; i++) {
			if(movieList[i].getTitle().equals(title))
				cnt++;
		}
		
		Movie[] result = new Movie[cnt];
		
		for (int i = 0; i < size; i++) {
			if(movieList[i].getTitle().equals(title))
				result[i] = movieList[i];
		}
		
		return result;
	}
	
	public double getRunningTimeAvg() {
		double result = 0;
		for (int i = 0; i < size; i++) {
			result += movieList[i].getRunningTime();
		}
		
		return result / size;
	}
}
