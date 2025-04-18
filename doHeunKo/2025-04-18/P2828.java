package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2828 {

	static int n,m,c,temp,left,right;
	static int ret=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		c=Integer.parseInt(br.readLine());
		left=1;
		right=m;
		for(int i=0;i<c;i++) {
			temp=Integer.parseInt(br.readLine());
			if(temp>=left && temp<=right) {
				continue;
			}else if(temp <left) {
				//왼쪽
				ret+=left-temp;
				left=temp;
				right=left+m-1;
				
			}else {
				//오른쪽
				ret+=temp-right;
				right=temp;
				left=temp-m+1;
				
			}
		}
		System.out.println(ret);
	}
	
}
