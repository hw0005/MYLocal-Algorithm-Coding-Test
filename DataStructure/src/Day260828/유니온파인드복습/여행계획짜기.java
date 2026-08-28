package Day260828.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행계획짜기 {
	static int[] parent;
	static int[][] dosi;
	static int[] route;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 여행계획 수
		
		// 초기화
		parent = new int[n + 1];
		for (int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		dosi = new int[n + 1][n + 1];
		for (int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<=n; j++) {
				dosi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		route = new int[m + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		//parent + dosi 유니온
		for (int i = 1; i<=n; i++) {
			for (int j=1; j<=n;j++) {
				if (dosi[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		// dosi + route find
		int idx = find(route[1]);
		for (int i = 2; i<=route.length; i++) {
			if (idx != find(route[i])) {
				System.out.println("NO");
				break;
			}
		}
		
		System.out.println("YES");
		
		
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
	private static int find(int idx) {
		if (idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}

}
