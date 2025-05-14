import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B14502 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int result = 0;
	static int N, M;
	static int[][] map;
	static ArrayList<Pos> list = new ArrayList<>();
	static ArrayList<Pos> virus = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] str2 = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str2[j]);
				// 빈칸 넣기
				if(map[i][j]==0) {
					list.add(new Pos(i,j));
				}
				
				if(map[i][j]==2) {
					virus.add(new Pos(i,j));
				}
			}
		}
		int[] arr = new int[3];
		comb(arr, 0, 0);
		System.out.println(result);
	}
	
	// 있는 애들 중 조합
	public static void comb(int[] selected, int start, int count) {
		// 벽을 3개 세웠을경우 카운팅해야함
		if(count==3) {
			int[][] map2 = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map2[i][j] = map[i][j];
				}				
			}
			boolean visited[][] = new boolean[N][M];
			for(int i :selected) {
				Pos pos = list.get(i);
				map2[pos.xPos][pos.yPos] = 1;
			}
			// virus bfs
			Queue<Pos> virusQueue = new LinkedList<>();
			// 큐에 넣기
			for(Pos pos : virus) {
				virusQueue.add(pos);
				visited[pos.xPos][pos.yPos] = true;
			}
			while(!virusQueue.isEmpty()) {
				Pos pos = virusQueue.poll();
				for(int i=0;i<4;i++) {
					int nx = pos.xPos + dx[i];
					int ny = pos.yPos + dy[i];
					
					if(nx <0 || ny <0 || nx >=N || ny >=M || visited[nx][ny]) {
						continue;
					}
					visited[nx][ny] = true;
					if(map2[nx][ny]==0) {
						map2[nx][ny] = 2;
						virusQueue.add(new Pos(nx,ny));
					}
					
				}
			}
			int value = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map2[i][j]==0) {
						value += 1;
					}
				}
			}
			//
			result = Math.max(value, result);
			return;
		}
		for(int i=start;i<list.size();i++) {
			selected[count] = i;
			comb(selected, i+1, count+1);
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
