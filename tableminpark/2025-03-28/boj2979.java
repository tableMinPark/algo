package boj.p0327;

import java.io.*;
import java.util.*;

public class boj2979 {

    static int[] price = new int[4];
    static int[] T = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 3; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) + 1;
            int e = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) {
                T[j]++;
            }
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += price[T[i]] * T[i];
        }

        System.out.println(sum);

        br.close();
    }
}
