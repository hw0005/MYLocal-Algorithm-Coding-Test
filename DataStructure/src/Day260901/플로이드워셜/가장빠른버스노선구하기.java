package Day260901.플로이드워셜;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장빠른버스노선구하기 {
	static int n, m;
	static long[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dist = new long[n + 1][n + 1];
		
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=n; j++) {
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
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			if(dist[start][end] > value) {
				dist[start][end] = value;
			}
		}
		
		for (int k = 1; k<=n; k++) {
			for (int i = 1; i<=n; i++) {
				for (int j = 1; j<=n; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=n; j++) {
				if (dist[i][j] == 100000001) {
					bw.write(0 + " ");
				}
				else {
					bw.write(dist[i][j] + " ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
		
		
	}
}
