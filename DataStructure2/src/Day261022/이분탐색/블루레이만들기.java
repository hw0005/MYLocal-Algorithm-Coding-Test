package Day261022.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); // 블루레이 개수
		
		int[] a = new int[n];
		
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			
			if (start <a[i]) {
				start = a[i];
			}
			end += a[i];
		}
		
		int answer = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 0;
			int sum = 0;
			
			for (int i=0; i<n; i++) {
				if (sum + a[i] > mid) {
					count++;
					sum=0;
				}
				sum += a[i];
			}
			
			
			
			if (sum != 0) {
				count++;
			}
			if (count > m) {
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
