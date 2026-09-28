package Day260928.동적계획법복습;

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
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] l = new int[n];
		l[0] = a[0];
		int result = l[0];
		
		for (int i=1; i<n; i++) {
			l[i] = Math.max(a[i], l[i-1] + a[i]);
			result = Math.max(result, l[i]);
		}
		
		int[] r = new int[n];
		r[n-1] = a[n-1];
		for (int i= n - 2; i>=0; i--) {
			r[i] = Math.max(a[i], r[i+1] + a[i]);
		}
		
		for (int i=1; i<n-1; i++) {
			int temp = l[i-1] + r[i+1];
			result = Math.max(temp, result);
		}
		System.out.println(result);
		

	}

}
