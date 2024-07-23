package com.ssafy.offline;

/*
 * 객체 생성 불가능
 * 자식클래스를 이용해서 사용한다.
 * 클래스가 인터페이스를 구현하기 위해서
 * "implements" 키워드 사용
 * 
 * 인터페이스 extends 인터페이스 A, 인터페이스 B, ...(다중 상속 가능)
 * 클래스 implements 인터페이스 A, 인터페이스 B, ...(다중 구현 가능)
 * 클래스 extends 클래스(단일 상속)
 * 
*/
public interface Server {
	/* public final static */ int PORT = 80;
//	public abstract void start();
//	public abstract void stop();
//	public abstract void restart();
	void start();  
	void stop();   
	void restart();
}
