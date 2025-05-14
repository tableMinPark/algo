import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2852 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+2][2];
		int[] timer = new int[N+2];
		int diff = 0;
		int Atime = 0;
		int Btime = 0;
		for(int i=1;i<=N;i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			if(a==1) {
				arr[i][0] = arr[i-1][0] + 1; 
				arr[i][1] = arr[i-1][1];
			} else {
				arr[i][1] = arr[i-1][1] + 1;
				arr[i][0] = arr[i-1][0];
			}
			String[] str2 = str[1].split(":");
			// 시간계산
			int t = Integer.parseInt(str2[0])*60 + Integer.parseInt(str2[1]);
			timer[i] = t;
			
		}
		arr[N+1][0] = arr[N][0];
		arr[N+1][1] = arr[N][1];
		timer[N+1] = 48*60;
		for(int i=1;i<=N;i++) {
			if(arr[i][0]>arr[i][1]) {
				Atime += timer[i+1] - timer[i];
			} else if(arr[i][0]<arr[i][1]) {
				Btime += timer[i+1] - timer[i];
			}
		}
		System.out.println(convert(Atime/60) +":"+convert(Atime%60));
		System.out.println(convert(Btime/60)+":"+convert(Btime%60));	
	}
	
	public static String convert(int a) {
		if(a < 10) {
			return "0"+Integer.toString(a);
		} else return Integer.toString(a);
	}
}
