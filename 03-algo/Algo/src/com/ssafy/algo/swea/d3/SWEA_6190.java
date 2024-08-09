package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_6190 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		int n, m;

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine().trim());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int result = -1;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int tmp = arr[i] * arr[j];

					if (isDanjo(tmp))
						result = Math.max(result, tmp);
				}
			}

			bw.append("#" + tc + " " + result);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static boolean isDanjo(int tmp) {
		String str = Integer.toString(tmp);
		char[] c = str.toCharArray();
		int cnt = 0;

		while (cnt < c.length - 1) {
			if (c[cnt] > c[cnt + 1]) {
				return false;
			}
			cnt++;
		}

		return true;
	}
}
