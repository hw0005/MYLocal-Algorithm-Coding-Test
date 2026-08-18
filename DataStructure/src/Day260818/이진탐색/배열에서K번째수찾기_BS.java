package Day260818.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열에서K번째수찾기_BS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		long start = 1;
		long end = k;
		long answer = 0;
		
		while(start <= end) {
			long middle = start + (end - start) / 2;
			long count = 0;
			
			for (int i = 1; i <= n; i++) {
				count += Math.min(middle / i, n); // i번째 행은 i번째 배수임 1번째행 -> 1, 2,3 2번째행 -> 2, 4, 6 그래서 
			}
			if (count < k) {
				start = middle + 1;
			}
			else { // 조건 만족 시 갱신
				answer = middle;
				end = middle - 1;
			}
		}
		System.out.println(answer);
	}

}
