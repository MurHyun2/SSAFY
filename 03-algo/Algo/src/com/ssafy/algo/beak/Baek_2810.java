package com.ssafy.algo.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String input = br.readLine();

		int ch = 1;

		for (int i = 0; i < T; i++) {
			if (input.charAt(i) == 'S') {
				ch++;
			} else {
				ch++;
				i++;
			}
		}

		if (ch > T)
			ch = T;

		System.out.println(ch);
	}
}
