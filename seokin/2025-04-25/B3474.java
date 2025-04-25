import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3474 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			int count =0;
			for(int j=5;j<=num;j*=5) {
				count += num/j;
			}
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
