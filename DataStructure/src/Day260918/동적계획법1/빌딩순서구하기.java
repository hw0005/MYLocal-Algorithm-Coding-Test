package Day260918.동적계획법1;

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
		
		int[][][] d = new int[n+1][l+1][r+1];
		int mod = 1000000007;
		
		d[1][1][1] = 1;
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
