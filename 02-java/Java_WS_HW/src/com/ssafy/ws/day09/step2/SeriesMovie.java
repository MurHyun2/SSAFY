package com.ssafy.ws.day09.step2;

public class SeriesMovie extends Movie {

	// 해당 시리즈 영화가 시리즈 중 몇번째 인지
	private int seriesNum;

	// 해당 시리즈 영화의 부제목
	private String episode;

	public SeriesMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
		// TODO Auto-generated constructor stub
	}

	public SeriesMovie(int seriesNum, String episode) {
		this.seriesNum = seriesNum;
		this.episode = episode;
	}

	@Override
	public String toString() {
		return super.toString() + "SeriesMovie [seriesNum=" + seriesNum + ", episode=" + episode + "]";
	}

}
