package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325 {
	
	static int n,m;
	
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] retArr;
	static int maxN;
	
	static void bfs(int st) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(st);
		visited[st]=true;
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			for(int i:arr[temp]) {
				if(visited[i])continue;
				retArr[i]++;
				visited[i]=true;
				q.add(i);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		
		visited=new boolean[n+1];
		retArr=new int[n+1];
		arr=new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++) {
			arr[i]=new ArrayList <Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}
		
		for(int i=1;i<n+1;i++) {
			visited=new boolean[n+1];
			bfs(i);
		}
		
		for(int i=1;i<n+1;i++) {
			if(retArr[i]>maxN) maxN=retArr[i];
		}
		
		for(int i=1;i<n+1;i++) {
			if(maxN==retArr[i])System.out.println(i);
		}
		
	}
}
