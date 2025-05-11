package boj.p0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj14502 {

    static int N, M, answer;
    static List<P> viruses, blanks;
    static int[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        viruses = new ArrayList<>();
        blanks = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                if (map[y][x] == 0) {
                    blanks.add(new P(y, x));
                } else if (map[y][x] == 2) {
                    viruses.add(new P(y, x));
                }
            }
        }

        answer = 0;
        for (int i = 0; i < blanks.size() - 2; i++) {
            for (int j = i + 1; j < blanks.size() - 1; j++) {
                for (int k = j + 1; k < blanks.size(); k++) {
                    map[blanks.get(i).y][blanks.get(i).x] = 1;
                    map[blanks.get(j).y][blanks.get(j).x] = 1;
                    map[blanks.get(k).y][blanks.get(k).x] = 1;
                    answer = Math.max(answer, bfs());
                    map[blanks.get(i).y][blanks.get(i).x] = 0;
                    map[blanks.get(j).y][blanks.get(j).x] = 0;
                    map[blanks.get(k).y][blanks.get(k).x] = 0;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int bfs() {
        Queue<P> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        for (P virus : viruses) {
            q.add(new P(virus.y, virus.x));
            v[virus.y][virus.x] = true;
        }

        while(!q.isEmpty()) {
            P now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || v[ny][nx]) continue;
                if (map[ny][nx] == 1) continue;

                q.add(new P(ny, nx));
                v[ny][nx] = true;
            }
        }

        int count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (v[y][x]) continue;
                if (map[y][x] == 1) continue;
                count++;
            }
        }

        return count;
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
