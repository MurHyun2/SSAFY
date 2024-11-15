package com.ssafy.off.day10.live;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03_ByteStreamTest2 {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("data/dog.jpg");
				FileOutputStream fos = new FileOutputStream("data/dog-copy-2.jpg");) {

			int b; // byte 바구니
			// 버퍼를 이용해서 read()
			byte[] buffer = new byte[10];
			
			while ((b = fis.read(buffer)) != -1) { // 입력 스트림으로 부터 버퍼에 바이트를 채운 다음
				fos.write(buffer, 0, b);
			}
			System.out.println("복사 끝.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("스트림은 알아서 닫혔습니다.");
	}
}
