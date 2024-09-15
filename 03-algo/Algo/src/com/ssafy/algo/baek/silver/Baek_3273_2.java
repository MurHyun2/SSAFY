package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_3273_2 {

	static int N, X, cnt;
	static int[] arr, cntArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		cntArr = new int[1000001]; // 1부터 1,000,000까지의 범위
		X = Integer.parseInt(br.readLine());

		// 입력 끝

		// 배열에 숫자 카운트
		for (int i = 0; i < N; i++) {
			cntArr[arr[i]]++;
		}

		cnt = 0;

		// 브루트 포스 방식으로 합 찾기
		for (int i = 0; i < N; i++) {
			int num = X - arr[i];

			// 배열 범위를 벗어나지 않고, num과 arr[i]가 사용되지 않았을 때
			if (num > 0 && num <= 1000000 && cntArr[arr[i]] > 0 && cntArr[num] > 0) {
				// 두 수가 다를 때만 카운트
				if (arr[i] != num) {
					cnt++;
					cntArr[arr[i]]--; // 두 숫자 모두 사용 처리
					cntArr[num]--;
				}
			}
		}

		System.out.println(cnt);
	}
}
