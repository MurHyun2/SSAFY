package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1213_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 1; i <= 10; i++) {
			br.readLine();
			String searchText = br.readLine();
			String input = br.readLine();
			
			int idx = 0;
			int count = 0;
			
			while (true) {
				if (!(input.contains(searchText)))
					break;
				
				String splitStr = input.substring(0, idx);
				
				if (splitStr.contains(searchText)) {
					input = input.substring(idx);
					count++;
					idx = 0;
				}
				idx++;
			}
			
			System.out.printf("#%d %d\n", i, count);
		}
	}
}
