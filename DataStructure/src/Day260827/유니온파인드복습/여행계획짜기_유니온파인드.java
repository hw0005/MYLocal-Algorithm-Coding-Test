package Day260827.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행계획짜기_유니온파인드 {
	static int[] parent;
	static int[][] dosi;
	static int[] route;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시 개수
		int m = Integer.parseInt(br.readLine()); // 여행 계획 속한 개수
		
		// 초기화
		parent = new int[n + 1];
		dosi = new int[n + 1][n + 1];
		route = new int[m + 1];
		
		for (int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				dosi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i<=m; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		//-----------초기화 끝
		
		// dosi + parent
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dosi[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		int idx = find(route[1]);
		for (int i = 2; i < route.length; i++) {
			if(find(route[i]) != idx) {
				System.out.println("NO");
				break;
			}
		}
		
		System.out.println("YES");
		
		
	}
	
	private static void union (int a, int b) {
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
