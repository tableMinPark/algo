package boj.p0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2828 {

    static int N, M, J, answer;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());

        answer = 0;
        start = 1;
        end = start + M - 1;
        for (int i = 0; i < J; i++) {
            int p = Integer.parseInt(br.readLine());

            if (start > p || p > end) {
                // 담을 수 없는 경우
                int s = Math.abs(start - p);
                int e = Math.abs(end - p);

                if (s < e) {
                    // 시작점이 더 가까운 경우
                    answer += s;
                    start -= s;
                    end -= s;
                } else if (s > e) {
                    // 종료점이 더 가까운 경우
                    answer += e;
                    start += e;
                    end += e;
                } else {
                    // 박스 사이즈가 1인 경우를 위한 조건
                    if (start - p > 0) {
                        // 왼쪽 이동
                        answer += s;
                        start -= s;
                        end -= s;
                    } else {
                        // 오른쪽 이동
                        answer += e;
                        start += e;
                        end += e;
                    }
                }
            }

        }

        System.out.println(answer);

        br.close();
    }
}
