import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		quad(0,0,N);
		System.out.println(sb.toString());
	}
	
	public static void quad(int x, int y, int size) {
		if(same(x,y,size)) {
			sb.append(arr[x][y]);
		}
		else {
			sb.append("(");
			quad(x, y, size/2);
			quad(x, y+size/2, size/2);
			quad(x+size/2, y, size/2);			
			quad(x+size/2, y+size/2, size/2);
			sb.append(")");
		}
		
	}
	
	public static boolean same(int x, int y, int size) {
		int num = arr[x][y];
		boolean result=true;
		if(size == 1)
			return result;
		else {
			for(int i=x;i<x+size;i++) {
				for(int j=y;j<y+size;j++) {
					if(arr[i][j] != num) {
						result = false;
						return result;
					}
				}
			}
		}
		return result;
	}
}
