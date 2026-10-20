package Day261020.이분탐색;

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
		int[] a = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			boolean find = false;
			int start = 0;
			int end = a.length - 1;
			int target = Integer.parseInt(st.nextToken());

			while (start <= end) {
				int midI = (start + end) / 2;
				int midV = a[midI];

				if (midV > target) {
					end = midI - 1;
				} else if (midV < target) {
					start = midI + 1;
				} else {
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
