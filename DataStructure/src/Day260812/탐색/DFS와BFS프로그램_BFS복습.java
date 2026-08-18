package Day260812.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS프로그램_BFS복습 {
	// 담을 1차원 1개(정답용)a, 노드 개수 n, 에지 개수 m, 시작점 start
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int n;
	static int m;
	static int start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		// 초기화 및 값넣기
		a = new ArrayList[n + 1];
		for (int i = 1; i < a.length; i++) {
			a[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			a[e].add(s);
		}
		
		// DFS - BFS순
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
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
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
