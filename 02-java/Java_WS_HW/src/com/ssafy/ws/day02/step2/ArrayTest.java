package com.ssafy.ws.day02.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArrayTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = { 1098765432 };
		System.out.println(arr[0]);

		int T = Integer.parseInt(br.readLine());
		String[] foods = new String[T];

		for (int i = 0; i < T; i++) {
			foods[i] = br.readLine();
		}
		for (String string : foods) {
			bw.write(string);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
