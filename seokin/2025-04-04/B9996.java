import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9996 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split("\\*");
		for(int i=0;i<num;i++) {
			String s = br.readLine();
			if(s.length() < str[1].length() +  str[0].length()) {
				sb.append("NE");
				// 이거 추가안해서 계속 틀림
				sb.append("\n");
				continue;
			}
			String front = s.substring(0, str[0].length());
			String back = s.substring(s.length() - str[1].length(), s.length());
			if(front.equals(str[0]) && back.equals(str[1])) {
				sb.append("DA");
			}				
			else sb.append("NE");
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
