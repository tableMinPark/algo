package boj.p0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {

    static int T;
    static Stack<Character> stack;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            stack = new Stack<>();
            String answer = "YES";

            for (char c : br.readLine().toCharArray()) {
                if (c == ')') {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }

            if (!stack.isEmpty()) {
                answer = "NO";
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
