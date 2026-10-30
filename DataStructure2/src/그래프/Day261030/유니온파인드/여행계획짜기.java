package 그래프.Day261030.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 여행계획짜기 {
	static int[] parent;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수
		
		parent = new int[n+1];
		map = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] route = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=m; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if(map[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		for(int i=2; i<route.length; i++) {
			if(find(route[1]) != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a!=b) {
			parent[b] = a;
		}
	}
	
	private static int find(int idx) {
		if(idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
}
