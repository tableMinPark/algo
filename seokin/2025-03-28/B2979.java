import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2979 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int C = Integer.parseInt(str[2]);
		ArrayList<Car> list = new ArrayList<>();
		for(int i=0;i<3;i++) {
			String str2[] = br.readLine().split(" ");
			list.add(new Car(Integer.parseInt(str2[0]), Integer.parseInt(str2[1])));
		}
		int result = 0;
		for(int i=1;i<=100;i++) {
			int carCount = 0;
			for(Car c : list) {
				if(c.startTime <=i && c.endTime >i) {
					carCount += 1;
				}
			}
			if (carCount==0) continue;
			result += Integer.parseInt(str[carCount-1]) * carCount;
		}
		System.out.println(result);
	}
	public static class Car{
		int startTime;
		int endTime;
		
		public Car(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}
