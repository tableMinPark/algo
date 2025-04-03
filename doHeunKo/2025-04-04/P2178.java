package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
	
	static final int[] dy = {-1,0,1,0};
	static final int[] dx= {0,1,0,-1};
	static int n,m;
	static int[][] a,visited;
	
	static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		a=new int[n][m];
		visited=new int[n][m];
		
		for(int i=0;i<n;i++){
			String str=br.readLine();
			for(int j=0;j<m;j++) {
				a[i][j]=str.charAt(j)-'0';
			}
		}
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (!inRange(ny, nx)) continue;
                if (a[ny][nx] == 1 && visited[ny][nx] == 0) {
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
        
        System.out.println(visited[n - 1][m - 1]);
	}

}
