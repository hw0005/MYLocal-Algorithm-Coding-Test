package Day260901.다익스트라복습.최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Edge>[] a;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		
		a = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		for (int i = 1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <=n; i++) {
			a[i] = new ArrayList<>();
		}
		for (int i = 0; i <m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			a[start].add(new Edge(end, value));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
		
		
		
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start,0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Edge now = queue.poll();
			int nowNode = now.node;
			
			if (!visited[nowNode]) {
				visited[nowNode] = true;
				for (Edge next : a[nowNode]) {
					if (!visited[next.node] && dist[next.node] > dist[nowNode] + next.value) {
						dist[next.node] = dist[nowNode] + next.value;
						queue.add(new Edge(next.node, dist[next.node]));
					}
				}
				
			}
		}
		return dist[end];
		
	}
}
