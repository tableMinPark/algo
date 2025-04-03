import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String[] str2 = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str2[j]);
			}
		}
		Queue<Pos> queue= new LinkedList<>();
		int min = Integer.MAX_VALUE;
		queue.add(new Pos(0,0,1));
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			if(pos.xPos == N-1 && pos.yPos == M-1) {
				min = Math.min(min, pos.value);
			}
			for(int i=0;i<4;i++) {
				int nxPos = pos.xPos + dx[i];
				int nyPos = pos.yPos + dy[i];
				
				if(nxPos <0 || nxPos >= N || nyPos < 0 || nyPos >= M || visited[nxPos][nyPos]) continue;
				
				if(map[nxPos][nyPos] !=0) {
					visited[nxPos][nyPos] = true;
					queue.add(new Pos(nxPos, nyPos, pos.value+1));
				}				
			}
		}
		System.out.println(min);
		
	}
	public static class Pos{
		int xPos;
		int yPos;
		int value;
		public Pos(int xPos, int yPos, int value) {
			this.xPos = xPos;
			this.yPos = yPos;
			this.value = value;
		}
	}

}
