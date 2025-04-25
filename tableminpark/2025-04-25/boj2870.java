package boj.p0425;

import java.io.*;
import java.util.*;

public class boj2870 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Character> chs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (char c : ch) {
                chs.add(c);
            }
            chs.add(' ');
        }

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2.length() == o1.length()) {
                // 길이가 같은 경우 각 자리 숫자 비교
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) == o2.charAt(i)) continue;

                    int first = o1.charAt(i)-'0';
                    int second = o2.charAt(i)-'0';

                    return first - second;
                }
            }
            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (char c : chs) {
            // 0 ~ 9 인 경우 저장
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
            // 숫자가 아니고, 저장된 문자열이 비어있지 않는 경우
            else if (!sb.toString().isEmpty()) {
                // 두자리 이상인 경우 앞에 '0' 제거
                if (sb.length() > 1) {
                    int index = 0;
                    while (sb.charAt(index) == '0' && index < sb.length() - 1) {
                        index++;
                    }
                    for (;index < sb.length();index++) {
                        number.append(sb.charAt(index));
                    }
                }
                // 한자리인 경우 저장
                else {
                    number.append(sb);
                }

                pq.add(number.toString());
                sb = new StringBuilder();
                number = new StringBuilder();
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!pq.isEmpty()) {
            answer.append(pq.poll()).append("\n");
        }

        System.out.println(answer);

        br.close();
    }
}
