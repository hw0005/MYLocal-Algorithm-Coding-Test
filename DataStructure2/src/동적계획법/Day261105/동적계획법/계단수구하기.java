package 동적계획법.Day261105.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long mod = 1000000000;
		long[][] d = new long[n+1][11];
		
		for (int i=1; i<=9; i++) {
			d[1][i] = 1;
		}
		
		for (int i=2; i<=n; i++) {
			d[i][0] = d[i-1][1];
			d[i][9] = d[i-1][8];
			for (int j=1; j<=8; j++) {
				d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % mod;
			}
		}
		
		long count = 0;
		for (int i=0; i<=9; i++) {
			count = (count + d[n][i]) % mod;
		}
		System.out.println(count);
	}

}
