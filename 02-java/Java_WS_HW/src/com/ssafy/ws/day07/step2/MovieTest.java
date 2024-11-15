package com.ssafy.ws.day07.step2;

public class MovieTest {
	public static void main(String[] args) {
		Movie movie1 = new Movie(1, "어바웃 타임", "리처드 커티스", "로맨스", 123);
		Movie movie2 = new Movie(2, "어바웃 타임 2", "리처드 커티스", "로맨스", 111);
		Movie movie3 = new SeriesMovie(2, "어바웃 타임 3", "리처드 커티스", "로맨스", 133, 1, "에피소드");
		SeriesMovie sr1 = new SeriesMovie(3, "어바웃 타임 4", "리처드 커티스", "로맨스", 145, 2, "에피소드");
		
		IMovieManager mm = MovieManagerImpl.getInstance();
		
		mm.add(movie1);
		mm.add(movie2);
		mm.add(movie3);
		mm.add(sr1);
		
		System.out.println("-------------getList-------------");
		Movie[] movieList = mm.getList();
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		System.out.println("-------------getMovies-------------");
		movieList = mm.getMovies();
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		System.out.println("-------------getSeriesMovies-------------");
		movieList = mm.getSeriesMovies();
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		System.out.println("-------------searchByTitle(어바웃 타임)-------------");
		movieList = mm.searchByTitle("어바웃 타임");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		System.out.println("-------------getRunningTimeAvg-------------");
		System.out.println(mm.getRunningTimeAvg());
	}
}
