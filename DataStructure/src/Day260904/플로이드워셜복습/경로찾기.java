package Day260904.플로이드워셜복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] dist = new int[n + 1][n + 1];
		
		for (int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				int v = Integer.parseInt(st.nextToken());
				dist[i][j] = v;
			}
		}
		
		for (int k = 1; k<=n; k++) {
			for (int i = 1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (dist[i][k] == 1 && dist[k][j] == 1) {
						dist[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
