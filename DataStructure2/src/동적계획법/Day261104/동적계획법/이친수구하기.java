package 동적계획법.Day261104.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[][] d = new long[n+1][2];
		d[1][1] = 1;
		d[1][0] = 0;
		
		for (int i=2; i<=n; i++) {
			d[i][1] = d[i-1][0];
			d[i][0] = d[i-1][0] + d[i-1][1];
		}
		
		System.out.println(d[n][1] + d[n][0]);
	}

}
