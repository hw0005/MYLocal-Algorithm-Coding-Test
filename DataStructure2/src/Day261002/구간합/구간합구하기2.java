package Day261002.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] d = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + a[i][j];
			}
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = d[x2][y2] - d[x1-1][y2] -d[x2][y1-1] + d[x1-1][y1-1];
			System.out.println(result);
		}
		
	}

}
