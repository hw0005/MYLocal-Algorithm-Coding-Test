package Day260825.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_인접리스트와BFS {
	static ArrayList<Integer>[] a;
	static ArrayList<Integer> answer;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화
		int n = Integer.parseInt(st.nextToken()); // 도시 개수
		int m = Integer.parseInt(st.nextToken()); // 도로 개수
		int k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		a = new ArrayList[n + 1];
		answer = new ArrayList<>();
		visited = new int[n + 1];
		
		// 배열에 인덱스 넣기
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		// 그리고 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s].add(e);
		}
		
		// 배열도 초기화 후 -1 넣기
		for (int i = 1; i <= n; i++) {
			visited[i] = -1;
		}
		
		BFS(x);
		
		// answer에 값담아서 오름차순 정렬
		for (int i = 1; i <= n; i++) {
			if (visited[i] == k) {
				answer.add(i);
			}
		}
		
		if (answer.isEmpty()) {
			System.out.println(-1);
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
		
		while (!queue.isEmpty()) {
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
