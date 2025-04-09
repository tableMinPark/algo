package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2583 {
	static int MAX_N=104;
	static int[][] a=new int[MAX_N][MAX_N];
	static int[] dy= {-1,0,1,0};
	static int[] dx= {0,1,0,-1};
	static int component,n,m,sq,result;
	static boolean[][] visited=new boolean[MAX_N][MAX_N];
	static List<Integer> results=new ArrayList<Integer>();
	
	static boolean inRange(int y,int x) {
		return y>=0 && y<n &&  x>=0 && x<m;
	}
	
	static void dfs(int y,int x) {
		visited[y][x]=true;
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(inRange(ny,nx) && !visited[ny][nx] && a[ny][nx]==0) {
				dfs(ny,nx);
				result++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		sq=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<MAX_N;i++) {
			Arrays.fill(a[i], 0);
			Arrays.fill(visited[i], false);
		}
		
		for(int i=0;i<sq;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			for(int j=y1;j<y2;j++) {
				for(int k=x1;k<x2;k++) {
					a[j][k]=1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result=1;
				if(!visited[i][j] && a[i][j]==0) {
					component++;
					dfs(i,j);
					results.add(result);
				}
				
			}
		}
		System.out.println(component);
		Collections.sort(results);;
		for (int ele : results) {
            System.out.print(ele+" ");
        }
		
	}
}
