package boj.p0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj4375 {

    static int N, A, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while((input = br.readLine()) != null) {

            N = Integer.parseInt(input);
            A = 1;
            answer = 1;

            while(true) {
                if (A % N == 0) {
                    System.out.println(answer);
                    break;
                } else {
                    A = (A * 10) + 1;

                    // 모듈러 연산 활용해서 int 범위 초과 방지
                    // x mod N = (x mod N) mod N
                    A = A % N;
                    answer++;
                }
            }
        }
        br.close();
    }
}
