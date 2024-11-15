package com.ssafy.off.day10.live;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test04_FilterStreamTest {
	public static void main(String[] args) {
		method01();
		method02();
	}

	private static void method01() {
		// 문자 스트림 : FileReader, FileWriter
		// 버퍼 기능을 추가해 보자 : BufferedReader, BufferedWriter
		try (BufferedReader reader = new BufferedReader(new FileReader("data/big_input.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("data/big_input_3.txt"))) {
			long start = System.nanoTime();
			String line; // BufferedReader은 입력을 줄 단위로 받는다.
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			System.out.println("복사 끝!");
			long end = System.nanoTime();
			System.out.println(end - start);
		} catch (IOException e) {

		}
	}

	private static void method02() {
		// 문자 스트림 : FileReader, FileWriter
		try (FileReader reader = new FileReader("data/big_input.txt");
				FileWriter writer = new FileWriter("data/big_input_3.txt")) {
			long start = System.nanoTime();
			int c; // 문자 버퍼를 채운 갯수
			char[] buffer = new char[10];
			while ((c = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, c);
			}
			System.out.println("복사 끝!");
			long end = System.nanoTime();
			System.out.println(end - start);

		} catch (IOException e) {

		}
	}
}