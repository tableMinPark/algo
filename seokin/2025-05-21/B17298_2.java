import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B17298_2 {
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		parent = new int[N];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		map.put(arr[N-1], -1);
		parent[N-1] = -1;
		for(int i=N-2;i>=0;i--) {
			if(arr[i] < arr[i+1]) {
				map.put(arr[i], arr[i+1]);
				parent[i] = arr[i+1];
			} else {
				parent[i] = find(arr[i] ,arr[i+1]);
				map.put(arr[i], parent[i]);
			}
		}
        StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(parent[i]+" ");
		}
        System.out.println(sb.toString());
	}
	static int find(int value, int i) {
		if(map.get(i)==-1) {
			return -1;
		}
		if(value < map.get(i)) {
			return map.get(i);
		} else {
			return find(value, map.get(i));
		}
	}

}