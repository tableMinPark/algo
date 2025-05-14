package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {
	
	
	static int n;
	static int c,cur=0;
	static String t="666";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		while(true) {
			cur++;
			if(String.valueOf(cur).contains(t)) {
				c++;
				if(c==n) {
					
					break;
				}
				
			}
			
		}
		
		System.out.println(cur);
	}
}
