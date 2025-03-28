package boj.p0327;

import java.io.*;

public class boj1159 {

    static int[] count = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            count[br.readLine().charAt(0)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                sb.append((char) (i+'a'));
            }
        }

        System.out.println(sb.length() == 0 ? "PREDAJA" : sb.toString());

        br.close();
    }
}
