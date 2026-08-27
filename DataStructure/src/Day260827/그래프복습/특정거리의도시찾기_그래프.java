package Day260827.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_그래프 {
	static int[] visited;
	static List<Integer> answer;
	static ArrayList<Integer>[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		
		// 1. 초기화
		a = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < m; i++) { 
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
		}
		
		visited = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited[i] = -1;
		}
		BFS(x);
		
		
		answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (visited[i] == k) {
				answer.add(i);
			}
		}
		
		if (answer.isEmpty()) {
			System.out.println("-1");
		}
		else {
			Collections.sort(answer);
			for (int i : answer) {
				System.out.println(i);
			}
		}

		
		
		
	}
	
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node]++;
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int i : a[nowNode]) {
				if (visited[i] == -1) { // 미방문 시
					visited[i] = visited[nowNode] + 1;
					queue.add(i);
				}
			}
			
		}
	}
}
