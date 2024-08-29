package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int N, win, lose, sum;
	static boolean[] selected;
	static int[] setCards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		N = 18;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			selected = new boolean[N + 1];
			setCards = new int[N / 2];
			win = 0;
			lose = 0;

			for (int i = 0; i < N / 2; i++) {
				setCards[i] = Integer.parseInt(st.nextToken());
				selected[setCards[i]] = true;
			}

			sum = 0;
			sum(N);

			pick(0, 0);

			bw.append("#" + tc + " " + win + " " + lose);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	private static void pick(int cnt, int sumVal) {
		if (cnt == N / 2) {
			if (sumVal > sum - sumVal)
				win++;
			else if (sumVal < sum - sumVal)
				lose++;

			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!selected[i]) {
				selected[i] = true;

				if (setCards[cnt] > i)
					pick(cnt + 1, sumVal + i + setCards[cnt]);
				else
					pick(cnt + 1, sumVal);

				selected[i] = false;
			}
		}
	}

	private static void sum(int num) {
		if (num <= 0)
			return;

		sum += num;
		sum(num - 1);
	}

}
