import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1012 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] str = br.readLine().split(" ");
			int M = Integer.parseInt(str[0]);
			int N = Integer.parseInt(str[1]);
			int K = Integer.parseInt(str[2]);
			map = new int[N][M];
			visited = new boolean[N][M];
			Queue<Pos> queue = new LinkedList<>();
			int count = 0;
			for(int j=0;j<K;j++) {
				String[] str2 = br.readLine().split(" ");
				int xPos = Integer.parseInt(str2[0]);
				int yPos = Integer.parseInt(str2[1]);
				map[yPos][xPos] = 1;
				queue.add(new Pos(xPos, yPos));
			}
			while(!queue.isEmpty()) {
				Pos pos = queue.poll();
				if(!visited[pos.yPos][pos.xPos]) {
					visited[pos.yPos][pos.xPos] = true;
					dfs(pos.xPos, pos.yPos);
					count += 1;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int xPos, int yPos) {
		for(int i=0;i<4;i++) {
			int nx = xPos + dx[i];
			int ny = yPos + dy[i];
			if(nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length || visited[ny][nx]) continue;
			visited[ny][nx] = true;
			if(map[ny][nx]==1) {
				dfs(nx, ny);
			}
		}
	}
	public static class Pos{
		int xPos;
		int yPos;
		public Pos(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
		}
	}
}
