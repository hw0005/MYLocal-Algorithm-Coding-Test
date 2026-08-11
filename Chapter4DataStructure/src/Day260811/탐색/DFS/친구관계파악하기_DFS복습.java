package Day260811.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구관계파악하기_DFS복습 {
	static boolean[] visited;
	static ArrayList<Integer>[] a;
	static boolean arrive;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 개수 n
		int m = Integer.parseInt(st.nextToken()); // 에지 개수 m
		
		
		// 1. 초기화
		visited = new boolean[n];
		a = new ArrayList[n];
		arrive = false;
		for (int i = 0; i< a.length; i++) {
			a[i] = new ArrayList<>();
		}
		
		// 2. 값 넣기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 양방향 저장
			a[s].add(e);
			a[e].add(s);
		}
		
		// 3. DFS실행 및 출력
		for (int i = 0; i < a.length; i++) {
			DFS(i, 1);
			if(arrive) {
				break;
			}
		}
		if (arrive) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
	
	private static void DFS(int now, int depth) {
		if (arrive || depth == 5) {
			arrive = true;
			return;
		}
		visited[now] = true;
		
		for (int i : a[now]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		visited[now] = false;
	}
	
}
