package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_ReTry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/4613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			Character[][] map = new Character[r][c];
			Character[] mColor = new Character[r];
			int[] mCount = new int[r];

			for (int x = 0; x < r; x++) {
				String str = br.readLine().trim();
				char[] ch = str.toCharArray();

				int wSum = 0;
				int bSum = 0;	
				int rSum = 0;

				for (int y = 0; y < c; y++) {
					map[x][y] = ch[y];

					if (ch[y] == 'W') {
						wSum++;
					} else if (ch[y] == 'B') {
						bSum++;
					} else if (ch[y] == 'R') {
						rSum++;
					}
				}

				char maxKey = 'W';
				int max = wSum;

				if (max < bSum) {
					max = bSum;
					maxKey = 'B';
				}

				if (max < rSum) {
					max = rSum;
					maxKey = 'R';
				}
				
				mColor[x] = maxKey;
				mCount[x] = max;
				
			}
			// 입력 끝
			
			for (int x = 0; x < r; x++) {
				System.out.println(mColor[x] + " " + mCount[x]);
			}
		}

	}
}
