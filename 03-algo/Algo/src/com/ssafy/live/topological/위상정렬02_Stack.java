package com.ssafy.live.topological;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬02_Stack {
	static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static String input = "9 9\r\n" + "	1 4\r\n" + "	1 8\r\n" + "	2 3\r\n" + "	4 3\r\n" + "	8 5\r\n"
			+ "	3 5\r\n" + "	5 6\r\n" + "	9 6\r\n" + "	6 7";
	static int V, E;
	static int[] degree;
	static int[][] adjArr;
	static boolean[] visited;
	static Stack<Integer> ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adjArr = new int[V + 1][V + 1];
		degree = new int[V + 1];
		visited = new boolean[V + 1];
		ans = new Stack<>();

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjArr[A][B] = 1; // 가중치는 따로 없으니 1로 표기
			degree[B]++; // 진입 차수 증가
		} // 입력 완료

		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0) {
				dfs(i);
			}
		}
		
		while(!ans.isEmpty()) {
			System.out.println(cook[ans.pop()]);
		}
	}

	private static void dfs(int idx) {
		visited[idx] = true;
		
		for (int i = 1; i <= V; i++) {
			if (adjArr[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
		ans.push(idx);
	}
}
