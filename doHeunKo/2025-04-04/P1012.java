package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1012 {

	static final int MAX_N = 54;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int[][] a = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static int m, n, t, c, component;
    static List<Integer> result = new ArrayList<>();

    static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (inRange(ny, nx) && a[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < MAX_N; j++) {
                Arrays.fill(a[j], 0);
                Arrays.fill(visited[j], false);
            }
            
            component = 0;
            for (int j = 0; j < c; j++) {
                st = new StringTokenizer(br.readLine());
                int xx = Integer.parseInt(st.nextToken());
                int yy = Integer.parseInt(st.nextToken());
                a[yy][xx] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (a[j][k] == 1 && !visited[j][k]) {
                        component++;
                        dfs(j, k);
                    }
                }
            }
            result.add(component);
        }
        
        for (int ele : result) {
            System.out.println(ele);
        }
    }
}