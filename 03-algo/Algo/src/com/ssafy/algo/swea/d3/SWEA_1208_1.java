package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 배열 생성 후 초기화
			int[] arr = new int[100];

			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int result = 0;

			// 평탄화 작업 시작
			for (int j = 0; j < T; j++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxIdx = 0;
				int minIdx = 0;

				// max와 min 값을 구함.
				for (int k = 0; k < 100; k++) {
					if (arr[k] > max) {
						max = arr[k];
						maxIdx = k;
					}

					if (arr[k] < min) {
						min = arr[k];
						minIdx = k;
					}
				}

				//평탄화 완료시 break 후 종료
				result = max - min;

				if (result <= 1)
					break;
				
				// max와 min 값이 들어간 idx를 찾아 각각의 값을 --, ++ 해줌.
				arr[maxIdx]--;
				arr[minIdx]++;
			}
			
			// 최종적으로 평탄화 결과를 계산
			int finalMax = Integer.MIN_VALUE;
            int finalMin = Integer.MAX_VALUE;
            
            for (int k = 0; k < 100; k++) {
                if (arr[k] > finalMax) {
                    finalMax = arr[k];
                }

                if (arr[k] < finalMin) {
                    finalMin = arr[k];
                }
            }

            result = finalMax - finalMin;

			// TC별 결과값 출력
			System.out.println("#" + i + " " + result);
		}
	}
}
