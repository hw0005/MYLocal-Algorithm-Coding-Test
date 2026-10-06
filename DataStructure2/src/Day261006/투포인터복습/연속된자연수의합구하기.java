package Day261006.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int s = 1;
		int e = 1;
		int count = 1;
		int sum = 1;
		
		while (e != n) {
			if (sum == n) {
				count++;
				e++;
				sum += e;
			}
			else if (sum < n) {
				e++;
				sum += e;
			}
			else {
				sum -= s;
				s++;
			}
		}
		System.out.println(count);
		
		
	}

}
