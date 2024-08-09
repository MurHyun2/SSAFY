package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			char[] c = str.toCharArray();
			int[] arr = new int[c.length];
			int cnt = 0;

			for (int i = 0; i < arr.length; i++) {
				int ctoi = c[i] - '0';
				if(ctoi != arr[i]) {
					for (int j = i; j < arr.length; j++) {
						arr[j] = ctoi;
					}
					cnt++;
				}
			}

			bw.append("#" + tc + " " + cnt);
			bw.newLine();
			bw.flush();
		}

		bw.close();
	}
}
