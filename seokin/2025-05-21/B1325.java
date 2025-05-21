import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int max = 0;		
		ArrayList<Integer> answer = new ArrayList<>();
		
		// 그래프 초기화
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		// 값추가
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(b).add(a);
		}
		// bfs
		for(int i=1;i<=N;i++) {
			boolean[] visited = new boolean[N+1];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			visited[i] = true;
			
			int count = 0;
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				for(int com : list.get(now)) {
					if(!visited[com]) {
						visited[com] = true;
						queue.add(com);
						count+=1;
					}
				}
			}
			if(count >= max) {
				if(count > max) {
					max = count;
					answer.clear();
				}
				
				answer.add(i);	
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// 정답 출력
		for(int i : answer) {
			sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}

}
