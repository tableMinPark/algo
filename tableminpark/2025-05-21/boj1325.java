package boj.p0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1325 {

    static int N, M, max;
    static List<List<Integer>> graph;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        max = 0;
        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            answer[i] = bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == answer[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static int bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N + 1];

        q.add(n);
        v[n] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (v[next]) continue;
                v[next] = true;
                count++;
                q.add(next);
            }
        }

        max = Math.max(max, count);

        return count;
    }
}
