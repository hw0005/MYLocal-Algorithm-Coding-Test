package 동적계획법.Day261103.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌딩순서구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		long[][][] d = new long[101][101][101];
		d[1][1][1] = 1;
		long mod = 1000000007;
		
		
		for (int i=2; i<=n; i++) {
			for (int j=1; j<=l; j++) {
				for (int k=1; k<=r; k++) {
					d[i][j][k] = (d[i-1][j-1][k] + d[i-1][j][k-1] + d[i-1][j][k] * (i-2)) % mod;
				}
			}
		}
		System.out.println(d[n][l][r]);
	}

}
