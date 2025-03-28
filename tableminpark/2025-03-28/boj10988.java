package boj.p0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        int head = 0;
        int tail = ch.length - 1;

        while(head < tail) {
            if (ch[head] != ch[tail]) {
                System.out.println("0");
                return;
            }

            head++;
            tail--;
        }

        System.out.println("1");

        br.close();
    }
}
