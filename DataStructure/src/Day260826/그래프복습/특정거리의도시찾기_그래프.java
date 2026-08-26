package Day260826.그래프복습;

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
	static ArrayList<Integer>[] a;
	static List<Integer> answer;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수, 간선
		int m = Integer.parseInt(st.nextToken()); // 도로 개수, 에지
		int k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		// 초기화 및 값 넣기
		a = new ArrayList[n + 1];
		visited = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
		}
		
		// 전체 다 돌기. 왜냐면 각 노드들 마다 한 번씩 다 검사해야 최솟값 알 수 있음.
		for (int i = 1; i <= n; i++) {
			visited[i] = -1;
		}
		
		// 출발 도시 번호
		BFS(x);
		
		
		// answer에 담은 후 오름차순
		answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (visited[i] == k) {
				answer.add(i);
			}
		}
		
		// 출력
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
		Queue<Integer> queue = new LinkedList<Integer>();
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
