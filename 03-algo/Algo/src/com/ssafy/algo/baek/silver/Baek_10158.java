package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine().trim());
		// System.in

		int dr = 1;
		int dc = 1;

		for (int i = 0; i < t; i++) {
			if (p == w)
				dr = -1;
			if (p == 0)
				dr = 1;
			if (q == h)
				dc = -1;
			if (q == 0)
				dc = 1;

			p += dr;
			q += dc;
		}

		bw.append(p + " " + q);
		bw.flush();
	}
}

// 배열 밖으로 나갈시 방향 전환
// 처음은 무조껀 r+1, c+1 방향으로 이동
// (0, y) 도달시 & (w, 0)에 도달하면 좌우 방향 전환
// c도 똑같음 상하 방향 전환
// 시간만큼 반복