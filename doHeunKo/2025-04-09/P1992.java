package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1992 {
	
	
	static int MAX_N=64;
	static int n;
	static char[][]a=new char[MAX_N][MAX_N];

	static StringBuilder sb=new StringBuilder();
	
	static void dfs(int y,int x, int sq) {
		
		char temp=a[y][x];
		boolean chk=true;
		
		
		for(int i=y;i<y+sq;i++) {
			for(int j=x;j<x+sq;j++) {
				if(a[i][j] != temp) {
					chk=false;
					break;
				}
			}
			if(!chk)break;
		}
		
		if(chk) {
			sb.append(temp);
			return;
		}
		
		sb.append("(");
		dfs(y,x,sq/2);
		dfs(y,x+sq/2,sq/2);
		dfs(y+sq/2,x,sq/2);
		dfs(y+sq/2,x+sq/2,sq/2);
		sb.append(")");
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringBuilder st=new StringBuilder(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j]=st.charAt(j);
			}
		}
		
		dfs(0,0,n);
		System.out.println(sb.toString());
		
	}
}
