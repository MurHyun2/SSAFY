package com.ssafy.ws.day04.step2;

public class Movie {
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
	
	public Movie() {
	}
	
	Movie(int id, String title, String director, String genre, int runningTime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}
}
