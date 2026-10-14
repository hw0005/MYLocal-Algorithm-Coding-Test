package Day261014.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS프로그램 {
	static ArrayList<Integer>[] a;
	static boolean[] visited;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		int v = Integer.parseInt(st.nextToken()); // 시작 번호
		
		a = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s].add(e);
			a[e].add(s);
		}
		
		for (int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		/// DFS
		visited = new boolean[n+1];
		DFS(v); // 시작번호
		
		
		System.out.println();
		
		/// BFS
		visited = new boolean[n+1];
		BFS(v); // 시작번호
		


	}
	
	private static void DFS(int num) {
		if (visited[num]) {
			return;
		}
		
		System.out.print(num + " ");
		visited[num] = true;
		for (int i : a[num]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
		
	}
	
	private static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		visited[num] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			
			for (int i : a[now]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}

}
