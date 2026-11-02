package 그래프.Day261102.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행계획짜기 {
	static int[] parent;
	static int[] route; // 여행 계획 도시
	static int[][] map; // 이어져있는 도시
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수
		
		parent = new int[n];
		map = new int[n][n];
		route = new int[m];
		
		for (int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			route[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		int firstRoute = find(route[0]);
		for (int i=1; i<m; i++) {
			if(firstRoute != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		

	}
	
	private static int find(int idx) {
		if(idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}

}
