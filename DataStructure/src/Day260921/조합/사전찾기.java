package Day260921.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사전찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] d = new int[202][202];
		
		for (int i=0; i<=200; i++) {
			d[i][0] = 1;
			d[i][1] = i;
			d[i][i] = 1;
		}
		
		for (int i=2; i<=200; i++) {
			for (int j=1; j<i; j++) {
				d[i][j] = d[i-1][j-1] + d[i-1][j];
				if (d[i][j] > 1000000000) {
					d[i][j] = 1000000001;
				}
			}
		}
		
		if (k > d[n+m][m]) {
			System.out.println(-1);
		}
		else {
			while (n !=0 || m!=0) {
				if (k <= d[n-1+m][m]) {
					System.out.print("a");
					n--;
				}
				else {
					System.out.print("z");
					k-= d[n-1+m][m];
					m--;
				}
			}
		}
		
	}

}
