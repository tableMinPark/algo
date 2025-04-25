package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10709 {
	static int MAX_N=104;
	static int h,w;
	static String [][] a=new String[MAX_N][MAX_N];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		h=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<h;i++) {
			
			String temp=br.readLine();
			int flag=0;
			for(int j=0;j<w;j++){
				
				if(temp.charAt(j)=='c') {
					a[i][j]="0";
					flag=1;
				}else {
					if(flag != 0) {
						a[i][j]=Integer.toString(flag);
						flag++;
					}
					else {
						a[i][j]="-1";
					}
				}
	
			}
		}
		
		for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(a[i][j]);
                if (j != w - 1) {
                    System.out.print(" ");  
                }
            }
            System.out.println(); 
        }
		
	}

}
