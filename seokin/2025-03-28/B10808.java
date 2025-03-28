import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10808 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		int arr[] = new int['z'-'a'+1];
		for(String s : str) {
			arr[s.charAt(0) - 'a'] ++;
		}
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}

}
