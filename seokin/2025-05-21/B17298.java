import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17298 {
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
		Stack<Integer> stack = new Stack<>();		
		for(int i=N-1;i>=0;i--) {
			// 스택이 비어있지않고, 스택에 가장 최근에 쌓인 값이 지금 값보다 클때까지 스택 비우기
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			// 스택이 비었으면, 오른쪽에 더 이상 큰 수가 없음
			if(stack.isEmpty()) {
				parent[i] = -1;
			} 
			// 스택이 남아있으면 스택 peek 가 오큰수
			else {
				parent[i] = stack.peek();
			}
			// 스택에 값 넣기
			stack.push(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(parent[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
