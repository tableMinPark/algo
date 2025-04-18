package boj.p0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj4659 {

    static String MO = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String input;
        while(!(input = br.readLine()).equals("end")) {

            char[] ch = input.toCharArray();

            // 1번 조건 (모음은 하나 이상 포함)
            boolean hasMo = false;
            for (char c : ch) {
                if (MO.contains(String.valueOf(c))) {
                    hasMo = true;
                    break;
                }
            }

            // 2번 조건 (자음, 모음이 연속으로 3번 안됨)
            boolean hasTriple = false;
            if (input.length() >= 3) {
                int moCount = 0;
                int jaCount = 0;
                for (int i = 0; i < 3; i++) {
                    if (MO.contains(String.valueOf(ch[i]))) {
                        moCount++;
                    } else {
                        jaCount++;
                    }
                }
                hasTriple = moCount == 3 || jaCount == 3;

                for (int h = 0, t = 3; t < ch.length; h++, t++) {
                    if (MO.contains(String.valueOf(ch[h]))) {
                        moCount--;
                    } else {
                        jaCount--;
                    }
                    if (MO.contains(String.valueOf(ch[t]))) {
                        moCount++;
                    } else {
                        jaCount++;
                    }
                    if (moCount == 3 || jaCount == 3) {
                        hasTriple = true;
                        break;
                    }
                }
            }

            // 3번 조건 (같은 문자가 두번 이상 오면 안됨, 하지만 'e', 'o' 는 두번까지 가능)
            boolean hasDouble = false;
            for (int i = 1; i < ch.length; i++) {
                if (ch[i - 1] == ch[i] && ch[i] != 'e' && ch[i] != 'o') {
                    hasDouble = true;
                    break;
                }
            }

            // 모음이 하나이상 포함하고, 자음 및 모음이 3번 연속이 아니고, 같은 문자가 2번 연속이 아닌 문자열 판별하여 출력 빌더 생성
            sb.append("<").append(input).append("> is ").append(hasMo && !hasTriple && !hasDouble ? "acceptable." : "not acceptable.").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
