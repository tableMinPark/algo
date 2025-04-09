package boj.p0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2468 {

    static int N, answer;
    static int[][] map;
    static boolean[][] v;
    static PriorityQueue<Integer> pq;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (!pq.contains(map[y][x])){
                    pq.offer(map[y][x]);
                }
            }
        }

        answer = 1;

        while(!pq.isEmpty()) {
            int z = pq.poll();

            v = new boolean[N][N];

            int area = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (v[y][x] || map[y][x] <= z) {
                        continue;
                    }
                    bfs(z, y, x);
                    area++;
                }
            }

            answer = Math.max(answer, area);
        }

        System.out.println(answer);

        br.close();
    }

    static void bfs(int z, int y, int x) {
        Queue<P> q = new ArrayDeque<>();
        q.offer(new P(y, x));
        v[y][x] = true;

        while(!q.isEmpty()) {
            P now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (v[ny][nx] || map[ny][nx] <= z) continue;

                q.offer(new P(ny, nx));
                v[ny][nx] = true;
            }
        }
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
