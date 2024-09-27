package com.ssafy.exam.board.model.dto;

public class Board {
	private int videoNum;
	private String videoURL;
	private String videoTitle;
	private String category;
	private String part;
	private String channelName;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int videoNum, String videoURL, String videoTitle, String category, String part, String channelName) {
		super();
		this.videoNum = videoNum;
		this.videoURL = videoURL;
		this.videoTitle = videoTitle;
		this.category = category;
		this.part = part;
		this.channelName = channelName;
	}

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public String toString() {
		return "Board [videoNum=" + videoNum + ", videoURL=" + videoURL + ", videoTitle=" + videoTitle + ", category="
				+ category + ", part=" + part + ", channelName=" + channelName + "]";
	}
}
