import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {
	static int[] arr = new int[9];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result[] = new int[7];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		comb(result, 0, 0);
		
		System.out.println(sb.toString());
	}
	
	public static void comb(int[] result, int count , int startCount) {
		if(count == 7) {
			if(sb.length()>0) return;
			int sum =0;
			for(int i : result) {
				sum += i;				
			}
			if(sum == 100) {
				for(int i : result) {
					sb.append(i).append("\n");
				}
			}
			return;
		}
		for(int i=startCount;i<arr.length;i++) {
			result[count] = arr[i];
			comb(result, count+1, i+1);
		}
	}

}
