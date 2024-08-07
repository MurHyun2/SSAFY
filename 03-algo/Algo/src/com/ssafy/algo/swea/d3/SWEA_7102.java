package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		int n, m;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int max = 0;

			int[] counting = new int[n + m + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					counting[i + j] += 1;
					max = Math.max(max, counting[i + j]);
				}
			}

			bw.append("#" + tc + " ");
			for (int i = 0; i <= n + m; i++) {
				if (max == counting[i]) {
					bw.append(i + " ");
				}
			}

			bw.newLine();
			bw.flush();
		}

		bw.close();
	}
}
