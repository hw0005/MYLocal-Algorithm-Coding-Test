package Day260930.동적계획법복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] d = new int[n+1][2];
		
		d[1][1] = 1;
		d[1][0] = 0;
		
		for (int i=2; i<=n; i++) {
			d[i][0] = d[i-1][0] + d[i-1][1];
			d[i][1] = d[i-1][0];
		}
		System.out.println(d[n][0] + d[n][1]);
	}

}
