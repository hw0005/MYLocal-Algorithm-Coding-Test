package Day261021.이분탐색복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 레슨 수
		int m = Integer.parseInt(st.nextToken()); // 블루레이 개수
		
		int[] a = new int[n];
		
		int start = 0; // 최소 수
		int end = 0; // 최댓값(합)
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken()); // 지금 들어온 수
			if (start < a[i]) {
				start = a[i];
			}
			end += a[i];
		}
		
		while(start <= end) {
			int middle = (start + end) / 2;
			int sum = 0;
			int count = 0;
			
			for (int i=0; i<n; i++) {
				if(sum + a[i] > middle) {
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
				answer = middle;
				end = middle - 1;
			}
		}
		System.out.println(answer);
		
	}
}
