package boj.p0327;

import java.io.*;
import java.util.Arrays;

public class boj2309 {

    static int[] heights = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        Arrays.sort(heights);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (i == j) continue;

                if (sum - heights[i] - heights[j] == 100) {
                    for (int k = 0; k < heights.length; k++) {
                        if (k != i && k != j) {
                            sb.append(heights[k]).append("\n");
                        }
                    }

                    System.out.println(sb);
                    return;
                }
            }
        }
        br.close();
    }
}
