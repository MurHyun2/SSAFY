package com.ssafy.algo.beak.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2798_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		// 배열에 값을 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 합을 담을 변수 & 가장 큰 값을 담을 변수 생성
		int sum = 0;
		int max = 0;
		
		//첫번째 숫자
		for (int i = 0; i < N - 2; i++) {
			
			// 두번째 숫자
			for (int j = i + 1; j < N - 1; j++) {
				
				// 세번째 숫자
				for (int k = j + 1; k < N; k++) {
					sum = arr[i] + arr[j] + arr[k];
					
					// 합이 기존의 max 값보다 크고, M값보다 같거나 작다면 max = sum 대입
					if(sum > max && sum <= M) {
						max = sum;
					}
				}
			}
		}
		
		//결과값 출력
		System.out.println(max);
	}
}
