import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10709 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		// 전부다 0으로 초기화 되어있음.
		int arr[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] str2 = br.readLine().split("");
			for(int j=0;j<M;j++) {
				if(str2[j].equals("c")) {
					for(int k=j;k<M;k++) {
						arr[i][k] = k - j +1;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]-1 + " ");
			}
			System.out.println();
		}
	}
}
