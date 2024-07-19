package com.ssafy.offline;

public class Test01Manager {
	private static Test01Manager instance = new Test01Manager();
	
	private Test01Manager() {
	}
	
	public static Test01Manager getInstance() {
		return instance;
	}
	
	void info() {
		System.out.println("INFO ABOUT TEST01");
	}

}
