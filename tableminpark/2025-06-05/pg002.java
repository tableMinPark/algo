import java.util.*;

// 생성한 정점	       0 | > 1
// 도넛 (모든 정점)	>= 1 | 1
// 막대 (마지막 정점)  >= 1 | 0
// 8자 (한 정점)	 >= 2 | 2
class Solution {public int[] solution(int[][] edges) {

    Map<Integer, Integer> out = new HashMap<>();
    Map<Integer, Integer> in = new HashMap<>();

    int[] answer = new int[4];

    for (int[] edge : edges) {
        out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
    }

    for (int node : out.keySet()) {
        if (out.get(node) > 1) {
            if (!in.containsKey(node)) {
                answer[0] = node;
            } else {
                answer[3] += 1;
            }
        }
    }

    for (int node : in.keySet()) {
        if (!out.containsKey(node)) {
            answer[2] += 1;
        }
    }

    answer[1] = out.get(answer[0]) - answer[2] - answer[3];
    return answer;
}
}