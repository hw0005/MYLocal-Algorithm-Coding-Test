package Day260810.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의_개수구하기_DFS {
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 개수 n
		int m = Integer.parseInt(st.nextToken()); // 에지 개수 m
		
		a = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		// 인접리스트 초기화
		for (int i = 1; i < a.length; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		// 인접리스트에 값넣기
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			a[e].add(s); // 양방향 저장
		}
		
		int count = 0;
		// DFS 실행
		for (int i = 1; i < a.length; i++) {
			if (!visited[i]) { // false라면 DFS 실행, cout++
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
	
	private static void DFS(int v) {
		if (visited[v] == true) {
			return;
		}
		
		visited[v] = true;
		for (int i : a[v]) {
			if (visited[i] == false) {
				DFS(i);
			}
		}
		
	}
	
	
}
