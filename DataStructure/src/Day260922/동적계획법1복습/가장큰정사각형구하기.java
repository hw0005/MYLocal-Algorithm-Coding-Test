package Day260922.동적계획법1복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰정사각형구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int[][] d = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j=1; j<=m; j++) {
				d[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		int max = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				
				if (d[i][j] == 1 && i>0 && j>0) {
					d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j], d[i][j-1])) + d[i][j];
				}
				if (max < d[i][j]) {
					max = d[i][j];
				}
			}
		}
		
		System.out.println(max * max);
		
	}

}
