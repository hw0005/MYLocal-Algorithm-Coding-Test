package Day260903.플로이드워셜복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장빠른버스노선구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 노선 수
		
		int[][] dist = new int[n + 1][n + 1];
		
		
		
		for (int i = 1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (i==j) {
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = 100000001;
				}
			}
		}
		
		
		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if (dist[s][e] > v) {
				dist[s][e] = v;
			}
		}
		
		for (int k = 1; k<=n; k++) {
			for (int i = 1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (dist[i][j] == 100000001) {
					System.out.print("0 ");
				}
				else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
	}

}
