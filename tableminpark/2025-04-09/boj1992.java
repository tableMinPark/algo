package boj.p0410;

import java.io.*;

public class boj1992 {

    static int N;
    static char[][] map;
    static int[] dy = {0, 0, 1, 1};
    static int[] dx = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int y = 0; y < N; y++) {
            map[y] = br.readLine().toCharArray();
        }

        System.out.println(recur(0, 0, N));

        br.close();
    }

    static String recur(int y, int x, int size) {
        if (size == 1) {
            return String.valueOf(map[y][x]);
        }

        int nextSize = size / 2;

        String[] temp = new String[4];

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d] * nextSize;
            int nx = x + dx[d] * nextSize;
            temp[d] = recur(ny, nx, nextSize);
        }
        boolean isSame = true;
        String compare = temp[0];

        for (int i = 1; i < 4; i++) {
            if (!compare.equals(temp[i]) || temp[i].length() > 1) {
                isSame = false;
                break;
            }
        }

        if (isSame) {
            return compare;
        } else {
            return "(" + temp[0] + temp[1] + temp[2] + temp[3] + ")";
        }
    }
}
