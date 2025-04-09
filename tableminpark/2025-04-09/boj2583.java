package boj.p0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2583 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] v;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            fillMap(sy, sx, ey, ex);
        }

        PriorityQueue<Integer> answer = new PriorityQueue<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (v[y][x] || map[y][x] == 1) {
                    continue;
                }

                answer.offer(bfs(y, x));
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(answer.size()).append("\n");

        while(!answer.isEmpty()) {
            sb.append(answer.poll()).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static void fillMap(int sy, int sx, int ey, int ex) {
        for (int y = sy; y < sy + (ey - sy); y++) {
            for (int x = sx; x < sx + (ex - sx); x++) {
                map[y][x] = 1;
            }
        }
    }

    static int bfs(int y, int x) {
        Queue<P> q = new ArrayDeque<>();

        q.offer(new P(y, x));
        v[y][x] = true;

        int area = 0;

        while(!q.isEmpty()) {
            P now = q.poll();

            area++;

            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (v[ny][nx] || map[ny][nx] == 1) continue;

                q.offer(new P(ny, nx));
                v[ny][nx] = true;
            }
        }

        return area;
    }

    static class P {
        int y;
        int x;

        public P(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
