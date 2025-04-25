package boj.p0425;

import java.io.*;

public class boj3474 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int count2 = 0;
            int count5 = 0;

            for(int k = 2; k <= num; k *= 2) {
                count2 += num / k;
            }
            for(int k = 5; k <= num; k *= 5) {
                count5 += num / k;
            }

            sb.append(Math.min(count2, count5)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
