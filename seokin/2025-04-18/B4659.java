import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4659 {

	public static void main(String[] args) throws IOException {
		String[] arr = {"a","e","i","o","u"};
		String ssss = "aeiou";
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) break;
			boolean flag = false;
			
			// 모음이 1개라도 있는지 판단
			for(String a : arr) {
				if(str.contains(a)) {
					flag = true;
				}
			}
			String[] strSplit = str.split("");
			
			// ee / oo Count
			int chkCount =0;
			
			// 모음, 자음 count
			int mCount = 0;
			int jCount = 0;
			String beforeS = strSplit[0];
			if(ssss.contains(beforeS)) {
				mCount += 1;
			} else {
				jCount += 1;
			}
			for(int i=1;i<strSplit.length;i++) {
				if(!flag) break;
				if(beforeS.equals(strSplit[i])) {
					if(strSplit[i].equals("e") || strSplit[i].equals("o")) {
						chkCount += 1;
						if(chkCount >= 2)
							flag=false;
					}
					else flag=false;
				} else {
					chkCount=0;
				}
				// 모음
				if(ssss.contains(strSplit[i])) {
					jCount = 0;
					mCount +=1;
				} else {
					mCount =0;
					jCount += 1;
				}
				
				if(mCount >=3|| jCount >=3) flag=false;
				
				beforeS = strSplit[i];
			}
			if(flag) {
				sb.append("<").append(str).append("> is acceptable.\n");
			}  else {
				sb.append("<").append(str).append("> is not acceptable.\n");
			}
		}
		System.out.println(sb.toString());
	}

}
