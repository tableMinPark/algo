import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2828 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int J = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = M;
		int answer = 0;
		for(int i=0;i<J;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a < start) {
				answer += start -a;
				end -= start-a;
				start = a;				
			}
			else if(end < a){
				answer += a - end;
				start += a - end;
				end = a;				
			}
		}
		System.out.println(answer);
	}

}
