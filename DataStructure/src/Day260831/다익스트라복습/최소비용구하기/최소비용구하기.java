package Day260831.다익스트라복습.최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static ArrayList<Edge>[] a;
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		
		// 초기화
		a = new ArrayList[n + 1];
		distance = new int[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i<=n ; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i<=n ; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 시작 
			int v = Integer.parseInt(st.nextToken()); // 끝
			int w = Integer.parseInt(st.nextToken()); // 가중치
			a[u].add(new Edge(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(start, end));
		
	}
	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node;
			
			if (!visited[nowNode]) {
				visited[nowNode] = true;
				
				for (Edge next : a[nowNode]) {
					if (!visited[next.node] && distance[next.node] > distance[nowNode] + next.value) {
						distance[next.node] = distance[nowNode] + next.value;
						pq.add(new Edge(next.node, distance[next.node]));
					}
				}
			}
		}
		return distance[end];
	}

}
