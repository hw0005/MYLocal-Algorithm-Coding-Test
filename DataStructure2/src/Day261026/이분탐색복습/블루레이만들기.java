package Day261026.이분탐색복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 레슨 수
		int m = Integer.parseInt(st.nextToken()); // 블루레이 수
	
		int start = 0;
		int end = 0;
		int answer = 0;
		
		int[]a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<n; i++) {
			if (a[i] > start) {
				start = a[i];
			}
			end += a[i];
		}
		
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 0;
			int sum = 0;
			
			for (int i=0; i< a.length; i++) {
				if (mid < sum + a[i]) {
					count++;
					sum = 0;
				}
				sum += a[i];
			}
			
			
			if (sum != 0) {
				count++;
			}
			if (count <= m) {
				answer = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		System.out.println(answer);
	}

}
