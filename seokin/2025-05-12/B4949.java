import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4949 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			String[] str = s.split("");
			Stack<String> stack = new Stack<String>();
			
			boolean chk = true;
			for(int i=0;i<str.length;i++) {
				if(str[i].equals("[")||str[i].equals("(")) {
					stack.add(str[i]);
				} else if(str[i].equals("]")||str[i].equals(")")){
					if(stack.isEmpty()) {
						chk = false;
						break;
					}
					if(str[i].equals("]")&&stack.pop().equals(("["))){
						continue;
					} else if(str[i].equals(")")&&stack.pop().equals(("("))) {
						continue;
					} else {
						chk = false;
					}
				}
			}
			if(!stack.isEmpty()) chk = false;
			if(!chk) sb.append("no\n");
			else sb.append("yes\n");
		}
		System.out.println(sb.toString());
	}
}
