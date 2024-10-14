package com.ssafy.music;

public class Album {
	private Artist artist;
	
	public Album(Artist artist) {
		this.artist = artist;
	}
	
	public void display() {
		System.out.println("가수는 : " + artist.getName());
	}
}
