import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3_대전_04_이대현 {

	// 메서드 사용을 위해 전역 변수 선언
	static int N, M;
	static int[][] arr;
	static int max;

	// 잡을 수 있는 물고기의 최댓값ㅇ르 구하는 catchFish() 메서드
	static void catchFish() {
		// max 값과 cnt 값을 0으로 초기화
		max = 0;
		int cnt = 0;

		// 배열의 크기만큼 순회
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 그물은 어장을 벗어날수 있으니 매번 cnt를 0으로 초기화
				cnt = 0;

				// 해당 위치에서 그물의 크기만큼 배열을 순회해 최댓값을 구함. ( 그물은 어장을 벗어날 수 있음 )
				for (int mr = 0; mr < M; mr++) {
					// nr 초기화
					int nr = r + mr;
					int nc;

					for (int mc = 0; mc < M; mc++) {
						// nc 초기화
						nc = c + mc;

						// 범위 지정 ( 0 <= nr, nc < N )
						if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
							// 매 실행마다 최댓값을 계산하므로 cnt는 이전값과 누적해서 합해줌
							cnt += arr[nr][nc];
						}

						// 매 실행 마다 최댓값을 계산
						max = Math.max(max, cnt);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// TestCase 개수를 받기 위한 변수 T 선언
		int T = Integer.parseInt(br.readLine().trim());

		// TestCase 별 출력
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			// 배열의 크기와 그물의 크기를 지정하기 위한 N, M의 값 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// arr 배열의 크기를 입력받은 N, N으로 크기 지정;
			arr = new int[N][N];

			// arr 배열을 입력값으로 초기화;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 잡을 수 있는 물고기의 최댓값을 구하는 catchFish() 메서드를 실행해 max값을 저장
			catchFish();

			// #TC 형태로 결과값 출력
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
