import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class B2910 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		String[] str2= br.readLine().split(" ");
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for(int i=0;i<N;i++) {
			int value = Integer.parseInt(str2[i]);
			if(map.get(value)==null) {
				map.put(value, 1);
				map2.put(value, i);
			}
			else {
				map.put(value, map.get(value)+1);
			}
			
		}
		
		
		PriorityQueue<Num> pq = new PriorityQueue<>();
		for(int i : map2.keySet()) {
			pq.add(new Num(i, map.get(i), map2.get(i)));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Num num = pq.poll();
			for(int i=0;i<num.count;i++) {
				sb.append(num.num+" ");
			}
		}
		System.out.println(sb.toString());
		
	}
	
	public static class Num implements Comparable<Num>{
		int num;
		int count;
		int position;
		
		public Num(int num, int count, int position) {
			this.num = num;
			this.count = count;
			this.position = position;
		}

		@Override
		public int compareTo(Num o) {
			if(this.count == o.count) {
				return this.position - o.position;
			}
			return o.count - this.count;
		}
	}
}
