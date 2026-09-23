package Day260923.동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱연산횟수의최솟값구하기 {
	static int n;
	static Matrix[] m;
	static int[][] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		m = new Matrix[n+1];
		d = new int[n+1][n+1];
		
		for (int i=0; i<d.length; i++) {
			for (int j=0; j<d[i].length; j++) {
				d[i][j] = -1;
			}
		}
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			m[i] = new Matrix(y, x);
		}
		
		
		System.out.println(excute(1, n));

	}
	
	public static int excute(int s, int e) {
		int result = Integer.MAX_VALUE;
		if (d[s][e] != -1) {
			return d[s][e];
		}
		
		if (s==e) {
			return 0;
		}
		if (s + 1== e) {
			return m[s].y * m[s].x * m[e].x;
		}
		for (int i=s; i<e; i++) {
			result = Math.min(result, m[s].y * m[i].x * m[e].x + excute(s, i) + excute(i+1,e));
		}
		return d[s][e] = result;
		
	}
	
	
	public static class Matrix {
		private int x;
		private int y;
		Matrix(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
