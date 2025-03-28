import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1159 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		for(int i=0;i<N;i++) {
			String name = br.readLine();
			arr[name.charAt(0)-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			if(arr[i] >= 5) sb.append((char)('a' + i));
		}
		if(sb.length()==0) {
			sb.append("PREDAJA");
		}
		System.out.println(sb.toString());
	}

}
