package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2468 {
	static int MAX_N=104;
	static int[] dy= {-1,0,1,0};
	static int[] dx= {0,1,0,-1};
	static boolean[][] visited=new boolean[MAX_N][MAX_N];
	static int[][] a=new int[MAX_N][MAX_N];
	static int h,n;


	static boolean inRange(int y,int x) {
		return y>=0 && y<n && x >=0 && x<n ;
	}
	
	static void dfs(int y,int x) {
		visited[y][x]=true;
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(inRange(ny,nx) && !visited[ny][nx] && a[ny][nx]>h  ) {
				dfs(ny,nx);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		int maxH=0;
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
				maxH=Math.max(maxH,a[i][j]);
			}
		}
		
		int maxComponent = 0;
		
		
		for(int k=0;k<=maxH;k++) {
			h=k;//h초기화 필요
			int component=0;
			visited = new boolean[MAX_N][MAX_N];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j] && a[i][j]>h) {
						component++;
						dfs(i,j);
					}
				}
			}
			maxComponent=Math.max(maxComponent,component);
		}
		
		
		System.out.println(maxComponent);

		
		
	}

}
