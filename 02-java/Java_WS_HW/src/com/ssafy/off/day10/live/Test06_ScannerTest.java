package com.ssafy.off.day10.live;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test06_ScannerTest {
	public static void main(String[] args) {
		method01();
		method02();
	}

	private static void method01() {
		// 문자 스트림 : FileReader, FileWriter
		// 버퍼 기능을 추가해 보자 : BufferedReader, BufferedWriter
		try (BufferedReader reader = new BufferedReader(new FileReader("data/big_input.txt"))) {
			long start = System.nanoTime();

			String line; // BufferedReader은 입력을 줄 단위로 받는다.

			while ((line = reader.readLine()) != null) {
				int num = Integer.parseInt(line);
			}

			long end = System.nanoTime();

			System.out.println(end - start);
		} catch (IOException e) {
		}
	}

	private static void method02() {
		try (Scanner sc = new Scanner(new FileInputStream("data/big_input.txt"))) {
			long start = System.nanoTime();

			while (sc.hasNext()) {
				int num = sc.nextInt();
			}

			long end = System.nanoTime();

			System.out.println(end - start);
		} catch (IOException e) {
		}
	}
}
