import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        // 더 많이 준 사람이 다음 달에 선물을 받음
        // 동일 조건인 경우 선물 지수가 큰 사람이 작은 사람한테 받음
        // 선물지수도 같은 경우 주고 받지 않음
        // 선물 지수 = 준 선물 - 받은 선물
        int N = friends.length;

        Map<String, Integer> friendsIndexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            friendsIndexMap.put(friends[i], i);
        }

        int[][] map = new int[N][N];
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            int from = friendsIndexMap.get(st.nextToken());
            int to = friendsIndexMap.get(st.nextToken());
            map[from][to]++;
        }

        // for (int from = 0; from < N; from++) {
        //     for (int to = 0; to < N; to++) {
        //         System.out.print(map[from][to] + " ");
        //     }
        //     System.out.println();
        // }

        int[] count = new int[N];
        for (int a = 0; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                int ac = map[b][a];
                int bc = map[a][b];

                if (ac == bc) {
                    int as = giveCount(map, a, N) - getCount(map, a, N);
                    int bs = giveCount(map, b, N) - getCount(map, b, N);

                    if (as > bs) {
                        count[a]++;
                    } else if (as < bs) {
                        count[b]++;
                    }

                } else if (ac < bc) {
                    count[a]++;
                } else if (ac > bc) {
                    count[b]++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, count[i]);
        }

        return answer;
    }

    public int getCount(int[][] map, int to, int N) {
        int sum = 0;
        for (int from = 0; from < N; from++) {
            sum += map[from][to];
        }
        return sum;
    }

    public int giveCount(int[][] map, int from, int N) {
        int sum = 0;
        for (int to = 0; to < N; to++) {
            sum += map[from][to];
        }
        return sum;
    }
}