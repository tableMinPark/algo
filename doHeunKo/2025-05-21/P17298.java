package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 {
	
	static int n,a;
	static int[] retArr;
	static int[] curArr;

	static Stack<Integer> s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		retArr=new int[n];
		curArr=new int[n];

		Arrays.fill(retArr, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			curArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<n;i++) {
			while(!s.isEmpty() && curArr[s.peek()]<curArr[i]) {
				retArr[s.peek()]=curArr[i];
				s.pop();
			}
			s.push(i);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(retArr[i]).append(" ");
		}
		System.out.println(sb);
	}
}
