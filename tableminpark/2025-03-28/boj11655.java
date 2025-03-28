package boj.p0327;

import java.io.*;

public class boj11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];

            if (c >= 'a' && c <= 'z') {
                int cn = c-'a';
                cn = cn + 13;
                cn = cn % 26;
                c = (char) (cn + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                int cn = c-'A';
                cn = cn + 13;
                cn = cn % 26;
                c = (char) (cn + 'A');
            }

            ch[i] = c;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }

        System.out.println(sb);

        br.close();
    }
}
