package com.ssafy.live.topological;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬01_Queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		String input = "9 9\r\n" + "	1 4\r\n" + "	1 8\r\n" + "	2 3\r\n" + "	4 3\r\n" + "	8 5\r\n"
				+ "	3 5\r\n" + "	5 6\r\n" + "	9 6\r\n" + "	6 7";

		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V + 1][V + 1];
		int[] degree = new int[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjArr[A][B] = 1; // 가중치는 따로 없으니 1로 표기
			// 진입 차수 증가
			degree[B]++;
		} // 입력 완료

		// 위상정렬 큐 1장 : 집입차수가 0인걸 모두 넣기
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0)
				q.add(i);
		}

		// 위상정렬 큐 2장 : 큐가 공백일때 까지 진행
		// 간선을 제거하고, 집입차수가 0이되면 큐에 넣기
		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.println(cook[now]);

			for (int i = 1; i <= V; i++) {
				if (adjArr[now][i] == 1) {
					degree[i]--;
					adjArr[now][i] = 0;

					if (degree[i] == 0)
						q.add(i);
				}
			}
		}
	}
}
