import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B2870 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<StringNum> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			String sNum="";
			for(int j=0;j<s.length();j++) {				
				if(s.charAt(j) >='0' && s.charAt(j)<='9') {
					if(sNum.equals("0")&& s.charAt(j)=='0') continue;					
					sNum += s.charAt(j);
				}
				else {
					if(sNum.equals("")) continue;
					if(sNum.length()>=2 && sNum.charAt(0)=='0') sNum = sNum.substring(1, sNum.length());
					pq.add(new StringNum(sNum));
					sNum = "";
				}
			}			
			if(!sNum.equals("")) {
				if(sNum.length()>=2 && sNum.charAt(0)=='0') sNum = sNum.substring(1, sNum.length());
				pq.add(new StringNum(sNum));
			}
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().str);
		}
		
	}
	
	public static class StringNum implements Comparable<StringNum>{
		String str;
		
		public StringNum(String str) {
			this.str = str;
		}

		@Override
		public int compareTo(StringNum o) {
			if(o.str.length() == this.str.length()) {
				for(int i=0;i<this.str.length();i++) {
					if(o.str.charAt(i)!=this.str.charAt(i)) {
						return this.str.charAt(i) - o.str.charAt(i);
					}
				}
			}
			return this.str.length() - o.str.length();
			
			
		}
		
	}

}
