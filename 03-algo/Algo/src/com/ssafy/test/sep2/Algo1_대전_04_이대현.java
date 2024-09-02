package com.ssafy.test.sep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1_대전_04_이대현 {
	static int N;
	static StringBuilder sb;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// TestCase의 갯수를 받기 위한 변수 T를 초기화
		int T = Integer.parseInt(br.readLine().trim());

		// TestCase 수 만큼 반복
		for (int tc = 1; tc <= T; tc++) {

			// 각 변수들을 초기화
			N = Integer.parseInt(br.readLine().trim());
			// 숫자들을 카운팅하는 arr 배열 초기화
			arr = new int[N];

			String str = br.readLine().trim();
			char[] c = str.toCharArray();

			// 숫자의 갯수들을 입력받고, 1줄이 완성됐는지 확인하는 star() 메서드 실행
			for (int i = 0; i < c.length; i++) {
				// 해당 열이 가득 차 있는 상태에서 또 다시 블록을 놓으려고 할 때는 무시
				if (arr[c[i] - '0'] < N) {
					arr[c[i] - '0']++;

					if (arr[c[i] - '0'] == 1)
						star();
				}
			}

			// 출력 형식에 맞게 #tc 번호 입력
			sb.append("#").append(tc);
			sb.append("\n");

			// 블록의 세로 칸의 크기
			int max = N;

			// 블록이 남았다면 반복
			while (max > 0) {
				// 모든 라인을 순회
				for (int i = 0; i < N; i++) {
					// 모든 칸에 대해 출력해야 되므로 블록이 max와 같다면 * 출력
					if (arr[i] == max) {
						sb.append("*");
						arr[i]--;
						// max칸 보다 작다면 " "(공백) 출력
					} else {
						sb.append(" ");
					}
				}
				// 한줄에 대한 출력이 끝났으니 줄바꿈
				sb.append("\n");
				// 한줄에 대한 출력이 끝났으니 max를 한칸 낮춰줌
				max--;
			}
		}

		// sb를 출력
		System.out.println(sb.toString());
	}

	// 1줄이 완성됐는지 확인하는 star() 메서드
	private static void star() {
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0)
				return;
		}

		// 1줄이 완성 되었다면 해당 행의 카운팅 배열인 arr의 값들을 전부 빼줌.
		for (int i = 0; i < N; i++)
			arr[i]--;
	}
}
