package com.ssafy.test.sep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_대전_04_이대현 {

	static int N, M, K, cnt;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		// TestCase의 갯수를 받기 위한 변수 T를 초기화
		int T = Integer.parseInt(br.readLine().trim());

		// TestCase 수 만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			// 각 변수들을 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			visited = new boolean[N];
			cnt = 0;

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			// 입력 끝

			// 경우의 수를 체크하기 위한 perm() 메서드 호출
			perm(0, 0);

			// 경우의 수가 없을 경우(0), -1 출력을 위한 조건문
			if (cnt == 0)
				cnt = -1;

			// 출력 형식에 맞게 가공 후 sb에 저장
			sb.append("#").append(tc).append(" ").append(cnt);
			sb.append("\n");
		}

		// sb 출력
		System.out.println(sb.toString());
	}

	// 순서가 상관있기 때문에 순열을 사용
	private static void perm(int depth, int sum) {
		// sum이 K보다 높을 경우 조건 만족을 못하니 바로 return
		if (sum > K)
			return;
		// 기저 조건 : depth가 M 과 같을 경우
		if (depth == M) {
			// 등번호의 합 sum이 K와 같다면 경우의 수(cnt) 증가
			if (sum == K)
				cnt++;

			return;
		}

		for (int i = 0; i < N; i++) {
			// 방문하지 않은 번호라면
			if (!visited[i]) {
				// 방문 체크
				visited[i] = true;
				// depth를 1 증가, sum에 arr[i]값을 더한 후 재귀 호출
				perm(depth + 1, sum + arr[i]);
				// 방문 체크 해제
				visited[i] = false;
			}
		}
	}
}