package boj.p0519;

import java.io.*;
import java.util.*;

public class boj2636 {

    static int N, M, answer, count;
    static int[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                if (map[y][x] == 1) {
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(count > 0) {

            int deleteCount = bfs();

            answer++;

            if (count - deleteCount == 0) {
                sb.append(answer).append("\n").append(count);
            }
            count -= deleteCount;
        }

        System.out.println(sb);
        br.close();
    }

    static int bfs() {
        Queue<P> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        q.add(new P(0, 0));
        v[0][0] = true;

        int deleteCount = 0;

        while(!q.isEmpty()) {
            P now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || v[ny][nx]) continue;

                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                    deleteCount++;
                } else {
                    q.add(new P(ny, nx));
                }

                v[ny][nx] = true;
            }
        }

        return deleteCount;
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
