package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char arr[] = str.toCharArray();
			int[] count = new int[8];

			for (int j = 0; j < arr.length; j++) {
				switch (arr[j]) {
				case '(':
					count[0]++;
					break;
				case ')':
					count[1]++;
					break;
				case '[':
					count[2]++;
					break;
				case ']':
					count[3]++;
					break;
				case '{':
					count[4]++;
					break;
				case '}':
					count[5]++;
					break;
				case '<':
					count[6]++;
					break;
				case '>':
					count[7]++;
					break;
				}
			}

			int result = 1;

			for (int j = 0; j < count.length - 1; j += 2) {
				if (count[j] != count[j + 1]) {
					result = 0;
					break;
				}
			}

			System.out.println("#" + i + " " + result);
		}
	}
}
