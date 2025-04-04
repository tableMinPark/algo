package boj.p0403;

import java.io.*;
import java.util.*;

public class boj2178 {

    static int N, M, answer;
    static int[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = -1;

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            char[] c = br.readLine().toCharArray();
            for (int x = 0; x < M; x++) {
                map[y][x] = c[x]-'0';
            }
        }

        bfs(0, 0);

        System.out.println(answer);
        br.close();
    }

    static void bfs(int y, int x) {
        Queue<P> queue = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        queue.offer(new P(y, x, 1));
        v[y][x] = true;

        while(!queue.isEmpty()) {

            P now = queue.poll();

            if (now.y == N - 1 && now.x == M - 1) {
                answer = now.d;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                if (map[ny][nx] == 0 || v[ny][nx]) {
                    continue;
                }

                queue.offer(new P(ny, nx, now.d + 1));
                v[ny][nx] = true;
            }
        }
    }

    static class P {
        int y;
        int x;
        int d;

        public P(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
