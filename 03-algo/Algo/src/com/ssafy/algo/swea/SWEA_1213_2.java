package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1213_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\com\\ssafy\\algo\\swea\\input\\1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 1; i <= 10; i++) {
			br.readLine();
			String searchText = br.readLine();
			String input = br.readLine();

			int count = 0;
			int stLength = searchText.length();
			int inputLength = input.length();

			input = input.replaceAll(searchText, " ");

			int repinputLength = input.length();
			count = inputLength - repinputLength;

			if((stLength - 1) != 0) {
				count /= (stLength - 1);
			}

			System.out.printf("#%d %d\n", i, count);

		}
	}
}
