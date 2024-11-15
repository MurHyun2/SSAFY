package com.ssafy.ws.day07.step2;

public interface IMovieManager {
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] searchByTitle(String title);
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovies();
	
	double getRunningTimeAvg();
}
