package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2870 {
	
	static int n;
	static List<String> res=new ArrayList<String>();
	
	static String rmZero(String s) {
		while(s.length()>0 && s.charAt(0)=='0') {
			s=s.substring(1);
		}
		return s.length()==0 ? "0" : s;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringBuilder sb=new StringBuilder(br.readLine());
			StringBuilder temp = new StringBuilder();

			
			
			for (int j = 0; j < sb.length(); j++) {
                char ch = sb.charAt(j);
                if (Character.isDigit(ch)) {
                    temp.append(ch);
                } else {
                    if (temp.length() > 0) {
                        res.add(rmZero(temp.toString()));
                        temp.setLength(0);
                    }
                }
            }

            if (temp.length() > 0) {
                res.add(rmZero(temp.toString()));
            }
				
		}
		Collections.sort(res, (a, b) -> {
            if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });

        for (String num : res) {
            System.out.println(num);
        }
		
	}
}
