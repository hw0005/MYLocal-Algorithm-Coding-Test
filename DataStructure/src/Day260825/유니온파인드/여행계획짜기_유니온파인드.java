package Day260825.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행계획짜기_유니온파인드 {
	static int[] parent;
	static int[][] dosi;
	static int[] route;
	
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 초기화
		n = Integer.parseInt(br.readLine()); // 도시 개수
		m = Integer.parseInt(br.readLine()); // 여행 개수
		parent = new int[n + 1];
		dosi = new int[n + 1][n + 1];
		route = new int[m + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				dosi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		//-------------------------------------------------- 초기화 끝
		
		// 도시 찾아서 parent에 합치기 -> dosi와 parent 유니온
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dosi[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		//  route 첫 번째 포함 안 돼있으면 정제된 parent와 평생 맞을 일 없으므로 false
		int idx = find(route[1]);
		for (int i = 2; i < route.length; i++) {
			if (idx != find(route[i])) {
				System.out.println("NO");
				return;
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
	
	private static int find (int idx) {
		// 루트노드라면 인덱스와 밸류 같다면
		if (idx == parent[idx]) {
			return idx;
		}
		
		// 아니라면 재귀 및 모든 노드 루트노트 찾고 저장
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
	


}
