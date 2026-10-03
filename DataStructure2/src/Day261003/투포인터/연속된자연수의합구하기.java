package Day261003.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		int count = 1;
		int startIdx = 1;
		int endIdx = 1;
		int sum = 1;
		while (endIdx !=n) {
			
			if (sum > n) {
				sum -= arr[startIdx];
				startIdx++;
			}
			else if (sum < n) {
				endIdx++;
				sum += arr[endIdx];
			}
			else {
				count++;
				endIdx++;
				sum += arr[endIdx];
			}
			
		}
		System.out.println(count);
	}

}
