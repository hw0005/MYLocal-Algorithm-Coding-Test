package Day260828.다익스트라복습.최단경로구하기복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로구하기 {
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge>[] list;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 노드 개수
		int e = Integer.parseInt(st.nextToken()); // 에지 개수
		int k = Integer.parseInt(br.readLine()); // 출발 번호
		
		// 초기화
		distance = new int[v + 1];
		visited = new boolean[v + 1];
		list = new ArrayList[v + 1];
		
		for (int i = 1; i<=v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[u].add(new Edge(w, value));
		}
		
		q.add(new Edge(k, 0));
		distance[k] = 0;
		
		while (!q.isEmpty()) {
			Edge now = q.poll();
			int nowNode = now.node;
			
			if(visited[nowNode]) {
				continue;
			}
			
			visited[nowNode] = true;
			for (int i = 0; i < list[nowNode].size(); i++) {
				Edge tmp = list[nowNode].get(i);
				int nextNode = tmp.node;
				int nextValue = tmp.value;
				if (distance[nextNode] > distance[nowNode] + nextValue) {
					distance[nextNode] = distance[nowNode] + nextValue;
					q.add(new Edge(nextNode, distance[nowNode]));
				}
			}
		}
		
		for (int i = 1; i<= v; i++) {
			if (visited[i]) {
				System.out.println(distance[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}

}
