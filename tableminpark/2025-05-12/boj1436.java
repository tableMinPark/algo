package boj.p0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1436 {

    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int number = 666;
        int n = 1;
        while (n != N) {
            number++;
            if (String.valueOf(number).contains("666")) n++;
        }

        System.out.println(number);

        br.close();
    }
}
