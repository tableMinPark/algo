package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {

	static final int[] dy = {-1,0,1,0};
	static final int[] dx= {0,1,0,-1};
	static int n,m;
	static int[][] a;
	static boolean[][] visited;
	static int count;
	static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
	
	static void bfs() {
		
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {0,0});
		visited[0][0]=true;
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int y=cur[0], x=cur[1];
			for(int i=0;i<4;i++) {
				int ny=y+dy[i];
				int nx=x+dx[i];
				
				if(inRange(ny,nx) && !visited[ny][nx]) {
					visited[ny][nx]=true;
					if(a[ny][nx]==0)q.add(new int[] {ny,nx});
					else {
						count--;
						System.out.println(ny+ " "+nx);
						a[ny][nx]=0;
					}
				}
				
			}
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		a=new int[n][m];
		
		count=0;
		for(int i=0;i<n;i++){
			StringTokenizer st1=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				a[i][j]=Integer.parseInt(st1.nextToken());
				if(a[i][j]==1)count++; 
					
			}
		}
			
		int cheese=0;
		int t=0;
		while(count!=0) {
			cheese=count;
			t++;
			visited=new boolean[n][m];
			bfs();
		}
        System.out.println(t + " "+ cheese);
        
	}

}
