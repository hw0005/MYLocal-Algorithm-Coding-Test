package Day260827.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기_그래프 {
	static boolean[] visited;
	static ArrayList<Integer>[] a;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
		int m = Integer.parseInt(st.nextToken()); // 신뢰 개수
		
		// 초기화
		a = new ArrayList[n + 1];
		answer = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
		}
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			BFS(i);
		}
		
		
		int maxValue = 0;
		for (int i = 1; i <= n; i++) {
			maxValue = Math.max(maxValue, answer[i]);
		}
		
		for (int i=1; i<=n; i++) {
			if (maxValue == answer[i]) {
				System.out.print(i + " ");
			}
		}
		
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int i : a[nowNode]) {
				if (!visited[i]) {
					answer[i]++;
					queue.add(i);
				}
			}
					
					
		}
		
	}
}
