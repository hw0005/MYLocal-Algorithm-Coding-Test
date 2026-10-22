package Day261022.이분탐색;

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
			int target = Integer.parseInt(st.nextToken());
			boolean result = false;
			int start = 0;
			int end = a.length - 1;

			
			while(start <= end) {
				int mid = (start + end) / 2;
				int midV = a[mid];
				
				if(midV > target) {
					end = mid - 1;
				}
				else if(midV < target) {
					start = mid + 1;
				}
				else {
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
