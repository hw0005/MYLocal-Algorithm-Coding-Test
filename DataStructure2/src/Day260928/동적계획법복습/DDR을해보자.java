package Day260928.동적계획법복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DDR을해보자 {

	public static void main(String[] args) throws IOException {
		
		int[][][] d = new int[100001][5][5];
		
		int[][] mp = {
				{0, 2, 2, 2, 2},
				{2, 1, 3, 4, 3},
				{2, 3, 1, 3, 4},
				{2, 4, 3, 1, 3},
				{2, 3, 4, 3, 1}
		};
		
		int n=0, s=1;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				for (int k=0; k<100001; k++) {
					d[k][i][j] = 100001 * 4;
				}
			}
		}
		d[0][0][0] = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (true) {
			n = Integer.parseInt(st.nextToken());
			if (n==0) {
				break;
			}
			
			for (int i=0; i<5; i++) {
				if (n==i) {
					continue;
				}
				for (int j=0; j<5; j++) {
					d[s][i][n] = Math.min(d[s-1][i][j] + mp[j][n], d[s][i][n]);
				}
			}
			
			for (int i=0; i<5; i++) {
				if (n==i) {
					continue;
				}
				
				for (int j=0; j<5; j++) {
					d[s][n][i] = Math.min(d[s-1][j][i] + mp[j][n], d[s][n][i]);
				}
			}
			s++;
		}
		s--;
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				min = Math.min(min, d[s][i][j]);
			}
		}
		System.out.println(min);
		
		
		
	}

}
