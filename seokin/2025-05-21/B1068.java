import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1068 {
	static int[] parent;
	static int N;
	static int rm;
	static boolean[] visited;
	static int count=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		visited = new boolean[N];
		String[] str = br.readLine().split(" ");
		int rm = Integer.parseInt(br.readLine());
		int root=0;
		for(int i=0;i<str.length;i++) {
			parent[i] = Integer.parseInt(str[i]);
			if(parent[i]==-1) root = i;
		}
		parent[rm] = -2;
		for(int i=0;i<N;i++) {
			if(find(i)==-2) {
				parent[i] = -2;
			}
		}
		count(root);
		System.out.println(count);
	}

	public static int find(int x) {
		if(parent[x] <0) {
			return parent[x];
		}
		return find(parent[x]);
	}
	
	public static void count(int x) {
		boolean leaf = true;
		visited[x] = true;
		// 삭제된 노드가 아닌경우
		if(parent[x]!=-2) {
			for(int i=0;i<N;i++) {
				if(parent[i]==x && visited[i]==false) {
					count(i);
					leaf = false;
				}
			}
			if(leaf) count+=1;
		}
		
	}
}
