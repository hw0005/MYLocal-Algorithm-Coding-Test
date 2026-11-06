package 동적계획법.Day261106.동적계획법복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속된정수의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] l = new int[n];
		int[] r = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		l[0] = a[0];
		int maxSum = 0;
		for (int i=1; i<n; i++) {
			l[i] = Math.max(a[i], l[i-1] + a[i]);
			maxSum = Math.max(maxSum, l[i]);
		}
		
		r[n-1] = a[n-1];
		for (int i=n-2; i>0; i--) {
			r[i] = Math.max(a[i], r[i+1] + a[i]);
		}
		
		for (int i=1; i<n; i++) {
			maxSum = Math.max(maxSum, l[i-1] + r[i-1]);
		}
		
		System.out.println(maxSum);
	}

}
