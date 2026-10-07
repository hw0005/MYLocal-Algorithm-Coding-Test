package Day261007.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 재료 개수
		int m = Integer.parseInt(br.readLine()); // 갑옷 완성되는 번호 합
		
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		int i=0;
		int j=n-1;
		int count=0;
		
		while (i<j) {
			int sum = a[i] + a[j];
			if (sum == m) {
				i++;
				j--;
				count++;
			}
			else if (sum > m) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.println(count);
		
		
	}
}
