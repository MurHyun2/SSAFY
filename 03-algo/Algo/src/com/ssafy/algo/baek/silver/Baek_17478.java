package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_17478 {
	
	static int T;
	static StringBuilder sb = new StringBuilder();;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine().trim());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		recursive(0);
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void recursive(int cnt) {
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < cnt; i++) {
			str.append("____");
		}
		
		if(cnt == T) {
			sb.append(str + "\"재귀함수가 뭔가요?\"\n"
					+ str + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
					+ str + "라고 답변하였지.\n");
			return;
		}
		
		sb.append(str + "\"재귀함수가 뭔가요?\"\n"
				+ str + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
				+ str + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
				+ str + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		recursive(cnt + 1);
		
		sb.append(str + "라고 답변하였지.\n");
	}
}
