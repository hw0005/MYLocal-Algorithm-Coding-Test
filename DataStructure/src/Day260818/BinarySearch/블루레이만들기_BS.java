package Day260818.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기_BS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 초기화
		int n = Integer.parseInt(st.nextToken()); // 레슨 수
		int m = Integer.parseInt(st.nextToken()); // 블루레이 개수
		int[] a = new int[n];
		
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			
			if (start < a[i]) {
				start = a[i];
			}
			end += a[i];
		}
		
		while (start <= end) {
			int middle = start + (end-start) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < m; i++) {
				if (sum + a[i] > middle) {
					count++;
					sum = 0;
				}
				sum += a[i];
			}
			if (sum != 0) {
				count++;
			}
			if (count > m) {
				start = middle + 1;
			}
			else {
				end = middle - 1;
			}
			
		}
		
		
		
	}
}
