package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1926.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());
		int now = 1;

		while (now <= N) {
			char[] c = Integer.toString(now).toCharArray();
			boolean check = false;

			for (int i = 0; i < c.length; i++) {
				if (c[i] == '3' || c[i] == '6' || c[i] == '9')
					check = true;
			}

			if (check) {
				for (int i = 0; i < c.length; i++) {
					if (c[i] == '3' || c[i] == '6' || c[i] == '9')
						sb.append("-");
				}
				
				sb.append(" ");
			} else 
				sb.append(now + " ");
			now++;
		}
		System.out.println(sb);
	}
}
