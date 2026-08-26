package Day260826.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기_그래프 {
	
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수, 노드
		int m = Integer.parseInt(st.nextToken()); // 신뢰관계 개수, 에지
		
		// 초기화 및 값넣기
		a = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		answer = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			a[start].add(end);
		}
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			BFS(i); // 모든 노드 실행
		}
		
		// 출력
		int maxValue = 0;
		for (int i = 1; i <= n; i++) {
			maxValue = Math.max(maxValue, answer[i]);
		}
		
		for (int i = 1; i <= n ; i++) {
			if (maxValue == answer[i]) {
				System.out.print(i + " ");
			}
		}
		
		
	}
	
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int i : a[nowNode]) {
				if (!visited[i]) {
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
			}
		}
		
		
	}

}
