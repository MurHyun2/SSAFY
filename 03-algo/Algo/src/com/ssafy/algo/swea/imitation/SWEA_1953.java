package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {

    static int N, M, R, C, L, cnt;
    static int[][] arr;
    static boolean[][] visited;
    static StringBuilder sb;
    static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
    static int[] dc = { 0, 0, -1, 1 };

    // 터널 타입별로 이동 가능한 방향 (상, 하, 좌, 우)
    static int[][] tunnel = {
        {},              // 0: 터널 없음
        {1, 1, 1, 1},    // 1: 상, 하, 좌, 우
        {1, 1, 0, 0},    // 2: 상, 하
        {0, 0, 1, 1},    // 3: 좌, 우
        {1, 0, 0, 1},    // 4: 상, 우
        {0, 1, 0, 1},    // 5: 하, 우
        {0, 1, 1, 0},    // 6: 하, 좌
        {1, 0, 1, 0}     // 7: 상, 좌
    };

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1953.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new boolean[N][M];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine().trim());

                for (int c = 0; c < M; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = 0;

            // BFS로 탐색 (Queue를 이용하여 L번 이동하는 동안 가능한 모든 위치 탐색)
            bfs(R, C);

            sb.append("#" + tc + " " + cnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c, 1 });  // 시작점에서 depth 1로 시작
        visited[r][c] = true;
        cnt++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];
            int depth = current[2];

            if (depth >= L)
                continue;

            int currentTunnel = arr[cr][cc];

            // 상,하,좌,우 이동
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && arr[nr][nc] != 0) {
                    int nextTunnel = arr[nr][nc];

                    // 현재 터널에서 나갈 수 있고, 이동할 터널에서 들어올 수 있는지 확인
                    if (tunnel[currentTunnel][i] == 1 && tunnel[nextTunnel][opposite(i)] == 1) {
                        queue.offer(new int[] { nr, nc, depth + 1 });
                        visited[nr][nc] = true;
                        cnt++;
                    }
                }
            }
        }
    }

    // 상(0), 하(1), 좌(2), 우(3)의 반대 방향을 반환
    private static int opposite(int direction) {
        if (direction == 0)
            return 1; // 상 -> 하
        if (direction == 1)
            return 0; // 하 -> 상
        if (direction == 2)
            return 3; // 좌 -> 우
        return 2; // 우 -> 좌
    }
}
