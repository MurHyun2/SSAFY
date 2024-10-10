package com.ssafy.movie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		ApplicationContext container = new GenericXmlApplicationContext("movie-config.xml");
		Movie movie = container.getBean(Movie.class);
		Movie movie2 = (Movie) container.getBean("movie");
		Movie movie3 = container.getBean("movie", Movie.class);
		
		System.out.println(movie == movie2);
		System.out.println(movie2 == movie3);
		movie.display();
	}
}
