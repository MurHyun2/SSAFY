import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1_대전_04_이대현 {

	// 메서드 사용을 위해 전역 변수 선언
	static int N, M;
	static char[][] arr;

	// 색칠해야 될 개수를 구하는 toColor 메서드. 칠해야될 색깔과, 현재 행을 매개변수로 받음.
	static int toColor(char color, int r) {
		// 색칠해야 될 개수를 0으로 초기화
		int cnt = 0;

		// 현재 행을 color값으로 칠해야 되는 개수를 계산.
		for (int c = 0; c < M; c++) {
			// 칠해야 될 색깔과 현재 색깔이 다르다면 cnt++
			if (arr[r][c] != color)
				cnt++;
		}

		// cnt 값 반환
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// TestCase 개수를 받기 위한 변수 T 선언
		int T = Integer.parseInt(br.readLine().trim());

		// TestCase 별 출력
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			// 행, 열의 값을 담기 위한 N, M의 값 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// arr 배열의 크기를 입력받은 N, M으로 크기 지정;
			arr = new char[N][M];

			// arr 배열을 입력값으로 초기화;
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			// 하얀색과 빨간색으로 칠해야 될 값을 구하기 위한 int형 변수 선언
			int wCnt = 0;
			int rCnt;
			// 최소값 계산을 위한 min 변수의 값을 MAX_VALUE로 초기화
			int min = Integer.MAX_VALUE;

			// 완전 탐색을 통한 최소값 구하기
			for (int i = 0; i < N - 1; i++) {
				// toColor 메서드의 반환값을 wCnt 값에 더해줌
				wCnt += toColor('W', i);
				// rCnt 값을 구하기 위해 0으로 초기화
				rCnt = 0;

				for (int j = i + 1; j < N; j++) {
					// toColor 메서드의 반환값을 rCnt 값에 더해줌
					rCnt += toColor('R', j);
				}

				// 기존의 min 값과 wCnt + rCnt (색칠해야 하는 총 개수)를 비교해 더 작은값을 min에 대입
				min = Math.min(min, wCnt + rCnt);
			}

			// #TC 형태로 결과값 출력
			System.out.printf("#%d %d\n", tc, min);
		}
	}
}
