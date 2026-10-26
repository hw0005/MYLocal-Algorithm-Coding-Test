package Day261026.이분탐색복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열에서K번째수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // n * n에서
		int k = Integer.parseInt(br.readLine()); // k번째 수 찾기
		
		
		long start = 1;
		long end = k;
		long answer = 0;
		
		while (start <= end) {
			long mid = (start + end) /2;
			long count = 0;
			
			for (int i=1; i<=n; i++) {
				count += Math.min(mid / i, n);
			}
			
			if (count < k) {
				start = mid + 1;
			}
			else {
				answer = mid;
				end = mid - 1;
			}
			
		}
		System.out.println(answer);
	}

}
