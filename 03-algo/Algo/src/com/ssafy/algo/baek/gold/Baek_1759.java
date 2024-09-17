package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1759 {

	static int L, C;
	static char[] arr, sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		sel = new char[L];

		String[] str = br.readLine().trim().split(" ");

		for (int i = 0; i < C; i++)
			arr[i] = str[i].charAt(0);
		// 입력 끝

		Arrays.sort(arr);

		comb(0, 0);

		System.out.println(sb.toString());
	}

	private static void comb(int now, int depth) {
		if (depth == L) {
			int v = 0;
			int g = 0;

			for (char c : sel) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					v++;
				else
					g++;
			}

			if (v >= 1 && g >= 2) {
				for (char c : sel)
					sb.append(c);

				sb.append("\n");
			}

			return;
		}
		for (int i = now; i < C; i++) {
			sel[depth] = arr[i];
			comb(i + 1, depth + 1);
		}
	}
}
