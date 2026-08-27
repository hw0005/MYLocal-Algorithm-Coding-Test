package Day260827.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합표현하기_유니온파인드 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 원소 개수
		int m = Integer.parseInt(st.nextToken()); // 질의 개수
		
		// 초기화
		parent = new int[n + 1];
		for (int i = 1; i<=n ;i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (question == 0) {
				union(a, b);
			}
			else {
				if (find(a) == find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			
		}
		
		
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
	
//	private static boolean isSame(int a, int b) {
//		a = find(a);
//		b = find(b);
//		if (a == b) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}

}
