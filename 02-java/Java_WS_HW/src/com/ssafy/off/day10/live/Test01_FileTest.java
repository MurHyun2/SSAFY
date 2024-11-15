package com.ssafy.off.day10.live;

import java.io.File;

public class Test01_FileTest {
	public static void main(String[] args) {
		// File : 파일 & 디렉토리 관리하기 위한 클래스
		File f = new File("data/dog.jpg"); // 상대경로 사용
		System.out.println(f.exists()); // 파일 존재 여부 확인
		System.out.println(f.isFile()); // 파일인지 확인
		System.out.println(f.isAbsolute()); //지정한 경로가 절대 경로인지 확인
		System.out.println(f.getAbsolutePath()); // 절대 경로 확인
		System.out.println(f.length() + " bytes."); // 파일의 바이트 크기
		
		File src = new File("src");
		System.out.println(src.exists());
		System.out.println(src.isDirectory());
		
		File folder = new File("folder");
		System.out.println(folder.exists());
//		folder.mkdir();
		
	}
}
