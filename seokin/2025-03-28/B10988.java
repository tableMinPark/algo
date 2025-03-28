import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10988 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean chk = true;
		for(int i=0;i<=str.length()/2;i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)){
				chk = false;
			}
		}
		System.out.println(chk? 1 : 0);
	}

}
