package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine().trim();
		int strLength = input.length();
		int r = 1;
		int c = 1;

		for (int i = 1; i * i <= strLength; i++) {
			if (strLength % i == 0) {
				r = i;
				c = strLength / i;
			}
		}

		char[][] map = new char[r][c];
		int idx = 0;

		for (int y = 0; y < c; y++) {
			for (int x = 0; x < r; x++) {
				map[x][y] = input.charAt(idx++);
			}
		}

		for (char[] ds : map) {
			for (char d : ds) {
				bw.append(d);
			}
		}

		bw.flush();
		bw.close();
	}
}
