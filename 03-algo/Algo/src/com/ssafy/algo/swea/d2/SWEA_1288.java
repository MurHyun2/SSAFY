package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1288 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1288.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());;

		for (int i = 1; i <= T; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[10];
			boolean check = true;
			char[] c;
			int cnt = 1;

			while (check) {
				c = Integer.toString(num * cnt).toCharArray();

				for (int j = 0; j < c.length; j++) {
					arr[c[j] - '0'] = 1;
				}

				for (int j = 0; j < 10; j++) {
					if (arr[j] == 0)
						break;
					else if (j == 9) {
						System.out.println("#" + i + " " + cnt * num);
						check = false;
					}
				}

				cnt++;
			}
			
		}
	}
}
