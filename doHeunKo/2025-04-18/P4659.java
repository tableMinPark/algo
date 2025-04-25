package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4659 {
	
	static char[] m= {'a','e','i','o','u'};
	static String mm="aeiou";
	static String str;
	
	private static boolean notMoem(char c) {
		return mm.indexOf(c)== -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int mcount=0;
			int zcount=0;
			int scount=0;
			str=br.readLine();
			if(str.equals("end"))break;
			
			boolean flag1=true;
			boolean isMoem=false;
			for(char c: m) {
				if(str.indexOf(c)!= -1) {
					isMoem=true;
					break;
				}
			}
			if(!isMoem)flag1=false;
			
			for(int i=0;i<str.length();i++) {
				char temp=str.charAt(i);
				if(notMoem(temp)) {//자음
					zcount++;
					mcount=0;
					if(zcount==3) {
						flag1=false;
						break;
					}
				}
				else {//모음
					mcount++;
					zcount=0;
					if(mcount==3) {
						flag1=false;
						break;
					}
				}
				
			}
			
			for(int i=1;i<str.length();i++) {
				char prev=str.charAt(i-1);
				char cur=str.charAt(i);
				
				if(prev==cur && !(cur=='e' || cur=='o')) {
					flag1=false;
					break;
				}
				
			}
			
			if(flag1) {
				System.out.println("<"+str+">"+" is acceptable.");
			}else {
				System.out.println("<"+str+">"+" is not acceptable.");
			}
			
		}
		
	}
}
