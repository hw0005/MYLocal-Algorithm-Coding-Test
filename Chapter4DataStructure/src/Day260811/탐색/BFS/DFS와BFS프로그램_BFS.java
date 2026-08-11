package Day260811.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS프로그램_BFS {
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n + 1];
		
		for (int i = 1; i < a.length; i++) {
			a[i] = new ArrayList<>();
		}
		
		// 값넣기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s].add(e);
			a[e].add(s);
		}
		
		// DFS, BFS 순
		visited = new boolean[n + 1];
		DFS(start);
		System.out.println();
		
		visited = new boolean[n + 1];
		BFS(start);
		System.out.println();
	}
	
	private static void DFS(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int i : a[start]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
		
	}
	
	private static void BFS(int start) {
		// 처음 들어온 것 해결 및 선언
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			// 빼서 기록 (출력)
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");
			
			for (int i : a[nowNode]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		
	}

	
	
	
}
