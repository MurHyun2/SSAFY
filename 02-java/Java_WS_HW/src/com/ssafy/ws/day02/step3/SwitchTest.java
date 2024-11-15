package com.ssafy.ws.day02.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int switchCnt = Integer.parseInt(st.nextToken());
		boolean[] switchStatus = new boolean[switchCnt];

		int T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			int input = Integer.parseInt(st.nextToken());

			for (int j = 2; j <= switchCnt; j++) {
				if (j % input == 0)
					switchStatus[j - 1] = !switchStatus[j - 1];
			}
		}

		for (boolean i : switchStatus) {
			System.out.print(i ? 1 : 0);
			System.out.print(" ");
		}
	}
}
