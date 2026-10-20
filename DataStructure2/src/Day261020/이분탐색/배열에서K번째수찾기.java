package Day261020.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열에서K번째수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 수 n
		int k = Integer.parseInt(br.readLine()); // k번째 수 찾기
		
		long start = 1;
		long end = k;
		long answer = 0;
		
		while (start <= end) {
			long middle = (start + end) / 2;
			long cnt = 0;
			
			for (int i=1; i<=n; i++) {
				cnt += Math.min(middle / i, n);
			}
			
			if (cnt < k) {
				start = middle + 1;
			}
			else {
				answer = middle;
				end = middle -1;
			}
		}
		System.out.println(answer);
	}

}
