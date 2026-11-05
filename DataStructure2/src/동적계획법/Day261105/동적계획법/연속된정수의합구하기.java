package 동적계획법.Day261105.동적계획법;

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
		
		//왼쪽부터 먼저 채우기
		l[0] = a[0];
		int result = a[0];
		for (int i=1; i<n; i++) {
			l[i] = Math.max(a[i], l[i-1] + a[i]);
			result = Math.max(result, l[i]);
		}
		
		// 오른쪽
		r[n-1] = a[n-1];
		for (int i=n-2; i>=0; i--) {
			r[i] = Math.max(a[i], r[i+1] + a[i]);
		}
		
		for (int i=1; i<n-1; i++) {
			int temp = l[i-1] + r[i+1];
			result = Math.max(result, temp);
		}
		
		System.out.println(result);

	}

}
