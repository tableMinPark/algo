package boj.p0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1068 {

    static int N, D, answer;
    static List<List<Integer>> graph;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        Map<Integer, Integer> m = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int p = Integer.parseInt(st.nextToken());
            m.put(n, p);
        }

        D = Integer.parseInt(br.readLine());

        // 루트가 하나라고는 안했음
        List<Integer> root = new ArrayList<>();
        for (int n : m.keySet()) {
            int p = m.get(n);

            // 삭제 노드와 관련된 모든 노드 패스
            if (n == D || p == D) continue;

            if (p == -1) {
                root.add(n);
            } else {
                graph.get(p).add(n);
            }
        }

        answer = 0;
        for (int r : root) {
            // 루트 노드 삭제 확인
            if (D != r) {
                dfs(r, 0);
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void dfs(int now, int depth) {
        if (graph.get(now).isEmpty()) {
            answer++;
            return;
        }

        for (int next : graph.get(now)) {
            dfs(next, depth + 1);
        }
    }
}
