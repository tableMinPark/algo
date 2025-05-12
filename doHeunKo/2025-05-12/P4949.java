package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
	
	static String str;
	
	static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			Stack<Character> st=new Stack<Character>();
			str=br.readLine();
			if(str.equals("."))break;
			
			for(char ch : str.toCharArray()) {
				if(ch=='(' || ch=='[') {
					st.push(ch);
				}else if(ch==')' || ch==']') {
					if(!st.isEmpty() && isMatchingPair(st.peek(), ch)) {
						st.pop();
					}else {
						st.push(ch);
						break;
					}
				}
			}
			if(st.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}
	}
	

}
