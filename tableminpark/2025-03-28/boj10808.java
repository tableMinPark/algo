package boj.p0327;

import java.io.*;

public class boj10808 {

    static int[] count = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (char ch : br.readLine().toCharArray()) {
            count[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : count) {
            sb.append(c).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
