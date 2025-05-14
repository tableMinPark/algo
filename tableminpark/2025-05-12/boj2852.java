package boj.p0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2852 {

    static int N;
    static int nowWinner;
    static int[] scores;
    static int[] winnerSeconds;
    static int[] answer;

    static List<E> e;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nowWinner = -1;
        scores = new int[2];
        winnerSeconds = new int[2];
        answer = new int[2];

        e = new ArrayList<>();
        e.add(new E(-1, 0, 0, 0));

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int teamIndex = Integer.parseInt(st.nextToken()) - 1;
            String[] timeSplit = st.nextToken().split(":");
            int seconds = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);

            int a = e.get(i - 1).a;
            int b = e.get(i - 1).b;

            if (teamIndex == 0) {
                a++;
            } else {
                b++;
            }

            int winner = -1;
            if (a > b) {
                winner = 0;
            } else if (a < b) {
                winner = 1;
            }

            e.add(new E(winner, a, b, seconds));
        }


        int a = e.get(e.size() - 1).a;
        int b = e.get(e.size() - 1).b;
        int winner = -1;
        if (a > b) {
            winner = 0;
        } else if (a < b) {
            winner = 1;
        }
        // 마지막 삽입
        e.add(new E(winner, a, b, 48 * 60));

//        System.out.println(e.get(0));

        for (int i = 1; i < e.size(); i++) {
//            System.out.println(e.get(i));

            E e1 = e.get(i - 1);
            E e2 = e.get(i);

            if (e2.winner == -1 || (e1.winner > -1 && e2.winner > -1)) {
                // 무승부가 된 경우
                if (e1.winner > -1) {
                    answer[e1.winner] += e2.seconds - e1.seconds;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", answer[0] / 60)).append(":").append(String.format("%02d", answer[0] % 60)).append("\n");
        sb.append(String.format("%02d", answer[1] / 60)).append(":").append(String.format("%02d", answer[1] % 60)).append("\n");

        System.out.println(sb);

        br.close();
    }

    static class E {
        int winner;
        int a;
        int b;
        int seconds;

        public E(int winner, int a, int b, int seconds) {
            this.winner = winner;
            this.a = a;
            this.b = b;
            this.seconds = seconds;
        }

        @Override
        public String toString() {
            return "E{" +
                    "a=" + a +
                    ", b=" + b +
                    ", winner=" + winner +
                    ", seconds=" + seconds +
                    '}';
        }
    }
}
