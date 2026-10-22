package Day261022.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열에K번째수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine()); // 3 * 3, n*n
		int k = Integer.parseInt(br.readLine()); // k번째 수
		
		long start = 1;
		long end = k; // k번째 수 찾는 거부터 end
		long answer = 0;
		
		
		while (start <= end) {
			long mid = (start + end) / 2; // mid값
			long cnt=0;
			
			
			for (int i=1; i<=n; i++) {
				cnt += Math.min(mid / i, n);
			}
			
			if (cnt < k) { // 카운트 센 게 k번째 수보다 많으면
				start = mid + 1;
			} else {
				answer = mid;
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
