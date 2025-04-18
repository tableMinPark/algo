package boj.p0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj2910 {

    static int N, C;
    static Map<Integer, Number> numberMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 출현 횟수 및 출현 순서 Map 에 저장
        numberMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            Number number = numberMap.getOrDefault(n, new Number(i, 0, n));
            number.count++;
            numberMap.put(n, number);
        }

        // 숫자 저장 Map 을 기준으로 정렬
        List<Number> numberList = numberMap.values()
                .stream()
                .sorted((n1, n2) -> {
                    // 출현 횟수 (카운트) 가 같은 경우 출현 순서가 빠른게 앞으로
                    if (n1.count == n2.count) {
                        return n1.index - n2.index;
                    }
                    // 출현 횟수 많은게 앞으로
                    return n2.count - n1.count;
                })
                .collect(Collectors.toList());

        // 출력 빌더 생성
        StringBuilder sb = new StringBuilder();
        for (Number number : numberList) {
            for (int i = 0; i < number.count; i++) {
                sb.append(number.value).append(" ");
            }
        }

        System.out.println(sb.toString().trim());

        br.close();
    }

    static class Number {
        int index;
        int count;
        int value;

        public Number(int index, int count, int value) {
            this.index = index;
            this.count = count;
            this.value = value;
        }
    }
}
