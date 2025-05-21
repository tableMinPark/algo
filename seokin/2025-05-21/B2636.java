import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2636 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int answerTime = 0;
		int[][] map = new int[N][M];
		boolean[][] visited;
		int count = 0;
		for(int i=0;i<N;i++) {
			String[] str2 = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str2[j]);
				if(map[i][j]==1) count += 1;
			}
		}
		int cheeseCount = count;
		// 치즈 다 녹을때까지
		while(count !=0) {
			cheeseCount = count;
			answerTime += 1;
			Queue<Pos> queue = new LinkedList<>();
			visited = new boolean[N][M];
			queue.add(new Pos(0,0));
			visited[0][0] = true;
			while(!queue.isEmpty()) {
				Pos nowC = queue.poll();
				for(int i=0;i<4;i++) {
					int nx = nowC.xPos + dx[i];
					int ny = nowC.yPos + dy[i];
					
					if(nx <0 || ny <0 || nx >=N || ny>=M || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					//치즈인경우
					if(map[nx][ny]==1) {
						map[nx][ny] = 0;
						count -=1;
					}
					// 그 외는 넣기
					else {
						queue.add(new Pos(nx, ny));
					}
				}
			}
		}
		System.out.println(answerTime);
		System.out.println(cheeseCount);
	}
	
	public static class Pos{
		int xPos;
		int yPos;
		Pos(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
		}
	}
}
