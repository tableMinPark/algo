import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11655 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().split("");
		for(String s : str) {
			char a = s.charAt(0);
			if(a >= 'A' && a <= 'Z') {
				a += 13;
				if(a > 'Z') {
					a += ('A'-'Z'-1);
				}
			}
			else if(a >= 'a' && a <= 'z') {
				a += 13;
				if(a > 'z') {
					a += ('a'-'z'-1);
				}
			}
			System.out.print(Character.toString(a));
		}
	}

}
