package com.ssafy.off.day10.live;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_ByteStreamTest {
	public static void main(String[] args) {
		// byte stream을 이용해서 이미지를 입출력 해보자!
		// stream => close() => finally

//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//
//		try {
//			fis = new FileInputStream("data/dog.jpg");
//			fos = new FileOutputStream("data/dog-copy.jpg");
//
//			int b; // byte 바구니
//
//			while ((b = fis.read()) != -1) { // 하나의 바이트를 읽어와서, 있다면
//				fos.write(b); // 하나의 바이트를 출력스트림에 쓴다.
//			}
//			System.out.println("복사 끝.");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fis != null)
//					fis.close();
//				if (fis != null)
//					fos.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		try (FileInputStream fis = new FileInputStream("data/dog.jpg");
				FileOutputStream fos = new FileOutputStream("data/dog-copy.jpg");) {

			int b; // byte 바구니

			while ((b = fis.read()) != -1) { // 하나의 바이트를 읽어와서, 있다면
				fos.write(b); // 하나의 바이트를 출력스트림에 쓴다.
			}
			System.out.println("복사 끝.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("스트림은 알아서 닫혔습니다.");
	}
}
