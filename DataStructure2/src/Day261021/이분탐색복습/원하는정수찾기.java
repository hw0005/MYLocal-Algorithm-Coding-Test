package Day261021.이분탐색복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원하는정수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			boolean result = false;
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = a.length - 1;
			
			while (start <= end) {
				int midI = (start + end) / 2;
				int midV = a[midI];
				
				if (target < a[midI]) {
					end = midI - 1;
				}
				else if (target > a[midI]) {
					start = midI + 1;
				}
				else {
					result = true;
					break;
				}
			}
			if(result) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}

	}

}
