package Day260819.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원하는정수찾기_이진탐색복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		// 값 넣기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			boolean find = false;
			int target = Integer.parseInt(st.nextToken());
			
			// 이진탐색 시작
			int start = 0;
			int end = a.length - 1;
			while (start <= end) {
				int midIdx = start + (end - start) / 2;
				int midValue = a[midIdx];
				if (midValue > target) {
					end = midIdx - 1;
				}
				else if (midValue < target) {
					start = midIdx + 1;
				}
				else {
					find = true;
					break;
				}
			}
			if (find) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			
		}
		
	}

}
