package com.ssafy.ws.day02.step2;

public class MovieTest {

	public static void main(String[] args) {
		Movie movie = new Movie(1, "어바웃 타임", "리처드 커티스", "로맨스", 123);
		Movie movie2 = new Movie(2, "어바웃 타임 2", "리처드 커티스", "로맨스", 111);
		
		System.out.println("-------------toStirng-------------");
		System.out.println(movie);
		System.out.println(movie2);
		
		MovieManager mm = new MovieManager();
		
		mm.add(movie);
		mm.add(movie2);
		
		System.out.println("-------------getList-------------");
		Movie[] movieList = mm.getList();
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		System.out.println("-------------searchByTitle(어바웃 타임)-------------");
		System.out.println(mm.searchByTitle("어바웃 타임"));
	}
}
