package 동적계획법.Day261107.동적계획법복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속된정수의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		int[] l = new int[n+1];
		int[] r = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=10; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		
		l[0] = a[0];
		int max = 0;
		
		for (int i=1; i<=n; i++) {
			l[i] = Math.max(a[i], a[i] + l[i-1]);
			max = Math.max(max, l[i]);
		}
		
		r[n-1] = a[n-1];
		for (int i=n-2; i>0; i--) {
			r[i] = Math.max(a[i], a[i]+r[i+1]);
		}
		
		for (int i=1; i<n; i++) {
			int temp = l[i-1] + r[i+1];
			max = Math.max(temp, max);
		}
		
		System.out.println(max);
	}

}
