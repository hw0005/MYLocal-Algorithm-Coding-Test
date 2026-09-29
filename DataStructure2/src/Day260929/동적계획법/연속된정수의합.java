package Day260929.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속된정수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n];
		int[] l = new int[n];
		int[] r = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		// l넣기
		l[0] = d[0];
		int result = l[0];
		for (int i=1; i<n; i++) {
			l[i] = Math.max(d[i], l[i-1] + d[i]);
			result = Math.max(result, l[i]);
		}
		
		r[n-1] = d[n-1];
		for (int i=n-2; i>=0; i--) {
			r[i] = Math.max(d[i], r[i+1] + d[i]);
		}
		
		for (int i=1; i<n-1; i++) {
			int temp = l[i-1] + r[i+1];
			result = Math.max(temp, result);
		}
		
		System.out.println(result);
		
		
		
		
	}

}
