package com.ssafy.ws.day02.step2;

public class Movie {
	private int id;
	private String title;
	private String director;
	private String genre;
	private int runningtime;
	
	public Movie() {
	}

	public Movie(int id, String title, String director, String genre, int runningtime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningtime = runningtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRunningtime() {
		return runningtime;
	}

	public void setRunningtime(int runningtime) {
		this.runningtime = runningtime;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", runningtime="
				+ runningtime + "]";
	}

}
