import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2583 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	public static void main(String[] args) throws IOException{

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int K = Integer.parseInt(str[2]);
		
		map = new int[M][N];
		
		for(int i=0;i<K;i++) {
			String str2[] = br.readLine().split(" ");
			int startX = Integer.parseInt(str2[0]);
			int startY = Integer.parseInt(str2[1]);
			int endX  = Integer.parseInt(str2[2]);
			int endY = Integer.parseInt(str2[3]);
			for(int j=startX;j<endX;j++) {
				for(int t=startY;t<endY;t++) {
					map[t][j] = 1;
				}
			}
		}
		boolean[][] visited = new boolean[M][N];
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				int area = 0;
				if(visited[i][j]) continue;
				visited[i][j] = true;
				if(map[i][j]==1) continue;
				count += 1;
				area = dfs(visited,i,j,area);
				list.add(area);
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for(int i : list) {
			System.out.print(i+ " ");
		}
	}
	
	public static int dfs(boolean[][] visited, int x, int y, int area) {
		area += 1;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= map.length || ny>=map[0].length || visited[nx][ny]) {
				continue;
			}
			visited[nx][ny] = true;
			if(map[nx][ny]==1) continue;
			area = dfs(visited, nx, ny, area);
		}
		return area;
	}
	

}
