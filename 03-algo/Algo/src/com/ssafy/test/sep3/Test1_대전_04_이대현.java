package com.ssafy.test.sep3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1_대전_04_이대현 {

	static int H;
	static long[] dp;
	static int[] jump = { 1, 3, 4 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// TestCase의 개수 T를 초기화
		int T = Integer.parseInt(br.readLine().trim());

		// T만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// 각 변수들을 초기화
			H = Integer.parseInt(br.readLine().trim());
			dp = new long[H + 1];

			// 0이 될수 있는 경우의 수는 아무것도 없는 하나밖에 없기 때문에 1로 설정
			dp[0] = 1;

			// 경우의 수 탐색을 위한 반복문 실행
			for (int i = 1; i <= H; i++) {
				for (int j = 0; j < 3; j++) {
					// j - jump[i] < 0 일 경우, 배열의 범위를 벗어남으로 continue
					if (i - jump[j] < 0)
						continue;

					// 경우의 수를 dp배열에 누적하여 저장
					dp[i] += dp[i - jump[j]];
				}
			}

			// 출력 형식에 맞게 StringBuilder에 입력
			sb.append("#").append(tc).append(" ");
			sb.append(dp[H]);
			sb.append("\n");
		} // tc 끝

		// StringBuilder 출력
		System.out.println(sb.toString());
	}
}