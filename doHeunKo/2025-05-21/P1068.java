package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1068 {
	static int n,delNode,ret;
	static ArrayList<Integer>[] g;
	
	
	static int dfs(int here) {
	    if (g[here].isEmpty()) return 1; 

	    boolean isLeaf = true;
	    int sum = 0;
	    for (int there : g[here]) {
	        if (there == delNode) continue;
	        isLeaf = false;
	        sum += dfs(there);
	    }

	    if (isLeaf) return 1;  
	    return sum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		g = new ArrayList[n];
	    for (int i = 0; i < n; i++) {
	        g[i] = new ArrayList<>();
	    }
	    
		int root=-1;
		for(int i=0;i<n;i++) {
			
			int p=Integer.parseInt(st.nextToken());
			if(p==-1) root=i;
			else  g[p].add(i);
		}
		delNode=Integer.parseInt(br.readLine());
		if(delNode==root) {
			System.out.println(0);
			return;
		}else {
			
			System.out.println(dfs(root));
		}
		
	}

}



