package Day261026.이분탐색복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원하는정수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 데이터 수

		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine()); // 찾아야 할 숫
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = a.length - 1;
			boolean result = false;
			
			while (start <= end) {
				int midIdx = (start + end) / 2;
				int midValue = a[midIdx];
				if (target > midValue) {
					start = midIdx + 1;
				} else if (target < midValue) {
					end = midIdx - 1;
				} else {
					result = true;
					break;
				}

			}
			if (result) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}

	}

}
