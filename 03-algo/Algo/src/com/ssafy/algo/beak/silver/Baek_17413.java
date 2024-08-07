package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();
		char[] c = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {

			if (c[i] == '<') {
				while (!stack.isEmpty())
					sb.append(stack.pop());

				while (c[i] != '>')
					sb.append(c[i++]);

				sb.append(c[i]);
			} else if (c[i] == ' ') {
				while (!stack.isEmpty())
					sb.append(stack.pop());

				sb.append(' ');
			} else {
				stack.push(c[i]);
			}

		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb);
	}
}

// 문자를 뒤집어야 하니 Stack을 사용
// 문자를 하나하나 추가해야 되니 StringBuilder 사용
// '<'와 ' '을 만나면 Stack에 담긴 문자들을 모두 pop
// '<'일 경우 '>'가 나올때 까지 그대로 출력해야 되니 SB에 바로 입력
// '<' & ' '을 만나기 전의 문자들은 뒤집어야 하니 Stack에 입력
// 루프가 끝나면 남아있는 Stack을 모두 SB에 입력
// SB 출력