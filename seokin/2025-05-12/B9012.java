import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9012 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			boolean a = true;
			String[] str = br.readLine().split("");
			int count = 0;
			for(int j=0;j<str.length;j++) {
				if(str[j].equals("(")) count += 1;
				else {
					count -=1;
					if(count < 0 ) a = false;
				}
			}
			if(count!=0) a= false;
			if(a) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}
}
