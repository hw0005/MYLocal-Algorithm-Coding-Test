package Day260819.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열에서K번째수찾기_이진탐색복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = k;
		int answer = 0;
		
		while (start <= end) {
			int middle = start + (end - start) / 2;
			int count = 0;
			for (int i = 1; i <= n; i++) {
				count += Math.min(middle / i, n);
			}
			
			if (count < k) {
				start = middle + 1;
			}
			else {
				answer = middle;
				end = middle - 1;
			}
		}
		System.out.println(answer);
	}

}
