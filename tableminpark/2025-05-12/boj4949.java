package boj.p0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {

    static Stack<Character> stack;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String input = "";
        while (!(input = br.readLine()).equals(".")) {
            stack = new Stack<>();
            String answer = "yes";

            for (char c : input.toCharArray()) {
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        answer = "no";
                        break;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        answer = "no";
                        break;
                    }
                } else if (c == '(' || c == '[') {
                    stack.push(c);
                }
            }

            if (!stack.isEmpty()) {
                answer = "no";
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
