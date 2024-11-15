package com.ssafy.ws.day04.step4;

/**
 * 맛집 정보를 나타내는 클래스
 */
public class Restaurant {
	int resId;
	String name;
	String address;
	String signatureMenu;
	int rate;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int resId, String name, String address, String signatureMenu, int rate) {
		this.resId = resId;
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		String result = String.format("Restaurant [resId=%d, name=%s, address=%s, signatureMenu=%s, rate=%d]", resId, name, address, signatureMenu, rate);
		return result;
	}
}
