package boj.p0425;

import java.io.*;
import java.util.*;

public class boj10709 {

    static int H, W;
    static int[][] map;
    static List<Cloud> clouds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        clouds = new ArrayList<>();

        for (int y = 0; y < H; y++) {
            char[] ch = br.readLine().toCharArray();
            for (int x = 0; x < W; x++) {
                if (ch[x] == 'c') {
                    clouds.add(new Cloud(y, x));
                    map[y][x] = 0;
                } else {
                    map[y][x] = -1;
                }
            }
        }

        int minutes = 1;
        while(!clouds.isEmpty()) {
            Iterator<Cloud> it = clouds.iterator();
            while(it.hasNext()) {
                Cloud cloud = it.next();

                cloud.x = cloud.x + 1;

                if (cloud.y < 0 || cloud.y >= H || cloud.x < 0 || cloud.x >= W) {
                    it.remove();
                } else if (map[cloud.y][cloud.x] == -1) {
                    map[cloud.y][cloud.x] = minutes;
                }
            }

            minutes++;
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static class Cloud {
        int y;
        int x;

        public Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
