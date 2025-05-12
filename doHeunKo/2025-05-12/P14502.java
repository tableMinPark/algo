package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {
	
	//1.벽세우고 초기화 필요 visited,a
	//2.개수 세기
	//3.max 개수 변수
	
	static int n,m,ret;
	static int[][] a=new int[10][10];
	static boolean[][] visited = new boolean[10][10];
	//static Queue<Pos> wallList=new LinkedList<>();
	static Queue<Pos> virusList=new LinkedList<>();
	static List<Pos> wallList = new ArrayList<>();
	static int[] dy={-1,0,1,0};
	static int[] dx= {0,1,0,-1};
	
	public static class Pos{
		int xPos;
		int yPos;
		public Pos(int xPos,int yPos) {
			this.xPos=xPos;
			this.yPos=yPos;
		}
	}
	
	public static boolean inRange(int y,int x) {
		return y<n && y>=0 && x<m && x>=0;
	}
	
	public static void dfs(int y,int x) {
		visited[y][x]=true;
		for(int i=0;i<4;i++){
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(!inRange(ny,nx) || visited[ny][nx] || a[ny][nx]>0) continue;
			dfs(ny,nx);
		}
	}
	
	public static int solve() {
		for (int i = 0; i < visited.length; i++) {
		    Arrays.fill(visited[i], false);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==2 && !visited[i][j]) {
					dfs(i,j);
				}
			}
		}
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==0 && !visited[i][j])cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st1=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				a[i][j]=Integer.parseInt(st1.nextToken());
				if(a[i][j]==0) {
					wallList.add(new Pos(i,j));
				}
				if(a[i][j]==2) {
					virusList.add(new Pos(i,j));
				}
			}
		}
		
		//순서가 중요하지 않은 조합
		for (int i = 0; i < wallList.size(); i++) {
		    for (int j = 0; j < i; j++) {
		        for (int k = 0; k < j; k++) {
		        	
		        	a[wallList.get(i).xPos][wallList.get(i).yPos]=1;
		        	a[wallList.get(j).xPos][wallList.get(j).yPos]=1;
		        	a[wallList.get(k).xPos][wallList.get(k).yPos]=1;
		        	ret=Math.max(ret,solve());
		        	a[wallList.get(i).xPos][wallList.get(i).yPos]=0;
		        	a[wallList.get(j).xPos][wallList.get(j).yPos]=0;
		        	a[wallList.get(k).xPos][wallList.get(k).yPos]=0;
		        }
		    }
		}
		System.out.println(ret);
	}
}
