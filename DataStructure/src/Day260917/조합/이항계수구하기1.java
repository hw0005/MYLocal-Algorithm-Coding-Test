package Day260917.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수구하기1 {
	static int[][] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		d = new int[n+1][n+1];
		
		for (int i=0; i<=n; i++) {
			d[i][0] = 1;
			d[i][i] = 1;
			d[i][1] = i;
		}
		
		for (int i=2; i<=n; i++) {
			for (int j=1; j<i; j++) {
				d[i][j] = d[i-1][j-1] + d[i-1][j];
			}
		}
		System.out.println(d[n][m]);
		
	}

}
