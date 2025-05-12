package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9012 {
	
	static int t;
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			str=br.readLine();
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') {
					sb.append('(');
				}else {
					if(sb.length()==0) {
						sb.append(')');
						break;
					}else {
						
						sb.deleteCharAt(sb.length()-1);
					}
				}
			}
			if(sb.length()>=1) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
