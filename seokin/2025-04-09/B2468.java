import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B2468 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int result = 1;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str[j]);
				set.add(map[i][j]);
			}
		}
		for(int i : set) {
			boolean[][] visited = new boolean[N][N];
			int count =0;
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					if(visited[x][y] || map[x][y] <= i) continue;
					visited[x][y]=true;
					dfs(i, visited, new Pos(x, y));
					count +=1;
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}
	public static void dfs(int rain, boolean[][] visited, Pos pos) {
		for(int i=0;i<4;i++) {
			int nx = pos.xPos + dx[i];
			int ny = pos.yPos + dy[i];
			
			if(nx <0 || ny <0 || nx >=map.length || ny>= map.length || visited[nx][ny]) {
				continue;
			}
			visited[nx][ny] = true;
			// 잠기는 지역
			if(rain >= map[nx][ny]) continue;
			dfs(rain, visited, new Pos(nx, ny));
		}
	}
	
	public static class Pos{
		int xPos;
		int yPos;
		
		Pos(int xPos, int yPos){
			this.xPos = xPos;
			this.yPos = yPos;
		}
	}
}
