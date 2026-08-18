package Day260811.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수구하기_DFS복습 {
	static boolean[] visited;
	static ArrayList<Integer>[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 개수 n
		int m = Integer.parseInt(st.nextToken()); // 에지 개수 m
		
		visited = new boolean[n + 1];
		a = new ArrayList[n + 1];
		int count = 0;
		
		// 1. 초기화
		for (int i = 1; i < a.length; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		// 2. 값넣기
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 양방향
			a[s].add(e);
			a[e].add(s);
		}
		
		// 3. DFS 실행
		for (int i = 1; i < a.length; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println(count);
	}
	
	private static void DFS(int now) {
		if (visited[now]) {
			return;
		}
		visited[now] = true;
		for (int i : a[now]) {
			if (visited[i] == false) {
				DFS(i);
			}
		}
		
	}
	
	
	
	
	
	
	

}
