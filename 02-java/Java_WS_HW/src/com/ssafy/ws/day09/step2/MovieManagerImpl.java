package com.ssafy.ws.day09.step2;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

	private List<Movie> movieList = new ArrayList<>();

	private static IMovieManager instance = new MovieManagerImpl();

	private MovieManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		movieList.add(movie);
	}

	@Override
	public Movie[] getList() {
		Movie[] list = new Movie[movieList.size()];
		return movieList.toArray(list);
	}

	@Override
	public Movie[] searchByTitle(String title) throws TitleNotFoundException {
		int size = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getTitle().contains(title))
				size++;
		}
		if (size == 0)
			throw new TitleNotFoundException(title);

		Movie[] list = new Movie[size];
		size = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getTitle().contains(title))
				list[size++] = movieList.get(i);
		}
		return list;
	}

	@Override
	public Movie[] getMovies() {
		int size = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if (!(movieList.get(i) instanceof SeriesMovie))
				size++;
		}

		Movie[] list = new Movie[size];
		for (int i = 0; i < movieList.size(); i++) {
			if (!(movieList.get(i) instanceof SeriesMovie))
				list[i] = movieList.get(i);
		}
		return list;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		int size = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) instanceof SeriesMovie)
				size++;
		}

		SeriesMovie[] list = new SeriesMovie[size];
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) instanceof SeriesMovie)
				list[i] = (SeriesMovie) movieList.get(i);
		}
		return list;
	}

	@Override
	public double getRunningTimeAvg() {
		double sum = 0;
		for (int i = 0; i < movieList.size(); i++) {
			sum += movieList.get(i).getRunningTime();
		}
		return sum / movieList.size();
	}

}
