package Day260921.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DDR을해보자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][][] dp = new int[100001][5][5];
		
		int[][] mp = {{0, 2, 2, 2, 2},
				{2, 1, 3, 4, 3},
				{2, 3, 1, 3, 4},
				{2, 4, 3, 1, 3},
				{2, 3, 4, 3, 1},
				};
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				for (int k=0; k<100001; k++) {
					dp[k][i][j] = 100001 * 4;
				}
			}
		}
		dp[0][0][0] = 0;
		
		int s = 1;
		while (true) {
			int n = Integer.parseInt(st.nextToken());
			if (n==0) {
				break;
			}
			
			// 오른발 움직이기
			for (int i=0; i<5; i++) {
				if (n==i) {
					continue;
				}
				for (int j=0; j<5; j++) {
					dp[s][i][n] = Math.min(dp[s][i][n], dp[s-1][i][j] + mp[j][n]);
				}
			}
			
			// 왼발 움직이기
			for (int j=0; j<5; j++) {
				if(n==j) {
					continue;
				}
				for (int i=0; i<5; i++) {
					dp[s][n][j] = Math.min(dp[s][n][j], dp[s-1][i][j] + mp[i][n]);
				}
			}
			s++;
		}
		s--;
		int min = Integer.MAX_VALUE;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				min = Math.min(min, dp[s][i][j]);
			}
		}
		System.out.println(min);
		
	
	}
}
