package boj.p0403;

import java.io.*;
import java.util.*;

public class boj1012 {

    static int T, N, M, V;
    static int[][] map;
    static boolean[][] v;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            v = new boolean[N][M];

            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int answer = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (v[y][x] || map[y][x] == 0) continue;
                    dfs(y, x);
                    answer++;
                }
            }

            sb.append(answer).append(t < T ? "\n" : "");
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int y, int x) {

        v[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M || v[ny][nx] || map[ny][nx] == 0) continue;

            dfs(ny, nx);
        }

    }
}
