package Day260928.동적계획법복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원의순회경로짜기 {
	static int INF = 1000000 * 16 + 1;
	static int[][] w;
	static int[][] d;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		d = new int[16][16];
		w = new int[16][1<<16];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0, 1));
		

	}
	
	private static int tsp(int c, int v) {
		if (v == (1<<n) - 1) {
			return w[c][0] == 0 ? INF : w[c][0];
		}
		if (d[c][v] != 0) {
			return d[c][v];
		}
		
		int minVal = INF;
		
		for (int i=0; i<n; i++) {
			if ( (v & (1 << i)) == 0 && w[c][i] != 0 ) {
				minVal = Math.min(minVal, tsp(i,(v | (1<<i))) + w[c][i]);
			}
		}
		d[c][v] = minVal;
		return d[c][v];
	}

}
