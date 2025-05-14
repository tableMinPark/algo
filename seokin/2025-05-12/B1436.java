import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int num = 666;
		while(true) {
			if(count==N) break;
			num += 1;
			if(Integer.toString(num).contains("666")) {
				count+=1;
			}
		}
		
		System.out.println(num);
	}
}
