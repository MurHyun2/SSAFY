import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2_대전_04_이대현 {

	// 메서드 사용을 위해 전역 변수 선언
	static int N, M;
	static int[][] arr;

	// 나이트의 이동 위치의 순서를 기존 행렬에 업데이트하는 메서드 선언
	static void moveKnight() {
		int cnt = 1;
		// 항상 (0, 0)의 위치에서 시작하니 1로 초기화
		arr[0][0] = cnt++;
		// 현재 위치를 담을 nr, nc 변수 선언
		int nr = 0;
		int nc = 0;

		// (0, 0)의 위치에 올 때까지 반복
		while (true) {
			// 이동한 위치를 정할때 범위를 넘어서는 것을 고려해 나머지 연산 실행
			nr = (nr + 2) % N;
			nc = (nc + 1) % M;

			// 이동한 위치가 (0, 0)의 좌표라면 종료
			if (nr == 0 && nc == 0)
				return;

			// arr배열의 (nr, nc)의 좌표에 이동 순서를 업데이트
			arr[nr][nc] = cnt++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// TestCase 개수를 받기 위한 변수 T 선언
		int T = Integer.parseInt(br.readLine().trim());

		// TestCase 만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			// 행, 열의 값을 담기 위한 N, M의 값 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// arr 배열의 크기를 입력받은 N, M으로 크기 지정;
			arr = new int[N][M];

			// 배열을 나이트의 이동순서로 초기화 하는 moveKnight() 메서드 실행
			moveKnight();

			// 문자열을 계속 추가해야 하니 sb(StringBulider) 사용
			sb.append("#" + tc + "\n");

			// 배열을 순회하면서 이동 순서를 sb에 추가
			for (int[] is : arr) {
				for (int i : is) {
					sb.append(i + " ");
				}

				sb.append("\n");
			}
		}

		// 결과값을 출력
		System.out.println(sb);
	}
}
