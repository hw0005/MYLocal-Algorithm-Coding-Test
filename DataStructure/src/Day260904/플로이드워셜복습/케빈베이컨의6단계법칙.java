package Day260904.플로이드워셜복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 유저 수
		int m = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		int[][] dist = new int[n + 1][n + 1];
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (i==j) {
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = 100000001;
				}
			}
		}
		
		for(int i= 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			dist[s][e] = 1;
			dist[e][s] = 1;
		}
		
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=m; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i=1; i<=n; i++) {
			int temp = 0;
			for (int j=1; j<=m; j++) {
				temp += dist[i][j];
			}
			
			if (min > temp) {
				min = temp;
				answer = i;
			}
		}
		
		System.out.println(answer);
		
	}

}
