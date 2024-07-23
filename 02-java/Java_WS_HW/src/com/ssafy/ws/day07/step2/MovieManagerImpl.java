package com.ssafy.ws.day07.step2;

import java.util.Arrays;

public class MovieManagerImpl implements IMovieManager {
	private final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	private static IMovieManager instance = new MovieManagerImpl();

	private MovieManagerImpl() {
	}

	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		if (size < MAX_SIZE)
			movieList[size++] = movie;
	}

	@Override
	public Movie[] getList() {
		return Arrays.copyOf(movieList, size);
	}

	@Override
	public Movie[] searchByTitle(String title) {
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().equals(title))
				idx++;
		}
		Movie[] arr = new Movie[idx];
		idx = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().equals(title)) {
				arr[idx] = movieList[i];
			}
		}
		return arr;
	}

	@Override
	public Movie[] getMovies() {
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie))
				idx++;
		}
		Movie[] arr = new Movie[idx];
		idx = 0;
		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				arr[idx] = movieList[i];
			}
		}
		return arr;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie)
				idx++;
		}
		SeriesMovie[] arr = new SeriesMovie[idx];
		idx = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				arr[idx] = (SeriesMovie) movieList[i];
			}
		}
		return arr;
	}

	@Override
	public double getRunningTimeAvg() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return sum / size;
	}
}
