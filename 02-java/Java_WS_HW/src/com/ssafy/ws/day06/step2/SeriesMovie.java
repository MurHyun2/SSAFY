package com.ssafy.ws.day06.step2;

public class SeriesMovie extends Movie {
	private int seriesNum;
	private String episode;
	
	public SeriesMovie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeriesMovie(int seriesNum, String episode) {
		this.seriesNum = seriesNum;
		this.episode = episode;
		// TODO Auto-generated constructor stub
	}
	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
		// TODO Auto-generated constructor stub
	}
	public int getSeriesNum() {
		return seriesNum;
	}
	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	@Override
	public String toString() {
		return super.toString() + ", SeriesMovie [seriesNum=" + seriesNum + ", episode=" + episode + "]";
	}
}
