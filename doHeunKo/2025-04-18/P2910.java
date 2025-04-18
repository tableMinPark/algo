package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;

import java.util.StringTokenizer;

public class P2910 {
	
	static int n,c;
	static int[] a;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> mp=new LinkedHashMap<>();
		
		n=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			
			int key=Integer.parseInt(st.nextToken());
			//System.out.println(key);
			if(mp.containsKey(key)) {
				mp.put(key, mp.get(key) + 1);
			}else {
				mp.put(key, 1);
			}
				
		}
		
		List<Map.Entry<Integer, Integer>> entry=new ArrayList<>(mp.entrySet());
		
		entry.sort(new Comparator<Map.Entry<Integer,Integer>>(){
			@Override
			public int compare(Map.Entry<Integer, Integer>a,Map.Entry<Integer, Integer>b) {
				int valueCompare = b.getValue().compareTo(a.getValue());
                if (valueCompare == 0) {
                    return 0;
                }
                return valueCompare; 
			}
		});
		
		
		for(Map.Entry<Integer, Integer> entrys:entry) {
			for(int i=0;i<entrys.getValue();i++) {
				System.out.print(entrys.getKey()+" ");
			}
		}
		
		
		
	}
}
