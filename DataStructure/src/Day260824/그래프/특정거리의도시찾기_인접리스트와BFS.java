package Day260824.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_인접리스트와BFS {

	static int n, m, k, x; // 노드수, 에지수, 목표 거리, 시작점
	static ArrayList<Integer>[] a; // 노드 담기
	static int[] visited; // 거리 담을 visit 배열
	static ArrayList<Integer> answer; // 답 담기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		a = new ArrayList[n + 1];
		answer = new ArrayList<>();
		visited = new int[n + 1];
		
		// 값 넣기 및 저장
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
		}
		
		// visit배열 초기화 값넣기 -1 세팅
		for (int i = 1; i <= n; i++) {
			visited[i] = -1;
		}
		
		// BFS
		BFS(x);
		
		// answer에 값 담기
		for (int i = 0; i <= n; i++) {
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
