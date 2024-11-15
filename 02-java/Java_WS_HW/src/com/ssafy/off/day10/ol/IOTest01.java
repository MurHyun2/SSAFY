package com.ssafy.off.day10.ol;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest01 {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("data/dog.jpg");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream("data/dog_copy.jpg");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			while (true) {
				int ch = bis.read();
				if (ch == -1)
					break;
				bos.write(ch);
			}
			System.out.println("End");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
