package Day260819.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기_이진탐색복습 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 레슨 수 (데이터 수)
		int m = Integer.parseInt(st.nextToken()); // 블루레이 수 (잘라야 하는 수)
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int start = 0;
		int end = 0;
		
		// 값 넣기
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if (start < a[i]) {
				start = a[i];
			}
			end += a[i];
		}
		
		// 이진 탐색 시작
		while (start <= end) {
			int middle = start + (end - start) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if(sum + a[i] > middle) {
					count++;
					sum = 0;
				}
				sum = sum + a[i];
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
		System.out.println(start);
		
		
	}

}
