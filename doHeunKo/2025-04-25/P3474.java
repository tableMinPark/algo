package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3474 {
	static int t,n,res;
	
	static int countZero(int num) {
		int count=0;
		while(num>=5) {
			count+=num/5;
			num/=5;
		}
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			n=Integer.parseInt(br.readLine());
			res=countZero(n);
			System.out.println(res);
		}
		
	}

}
