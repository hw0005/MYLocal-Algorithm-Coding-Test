package Day260828.다익스트라복습.최소비용구하기복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	
	static ArrayList<Edge>[] list;
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine());  // 버스 수
		
		
		// 초기화
		list = new ArrayList[n + 1];
		distance = new int[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i<=n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end, value));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start, 0));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node;
			
			if (!visited[nowNode]) {
				visited[nowNode] = true;
				
				for (Edge next : list[nowNode]) {
					int nextNode = next.node;
					int nextValue = next.value;
					
					if(distance[nextNode] > distance[nowNode] + nextValue) {
						distance[nextNode] = distance[nowNode] + nextValue;
						pq.add(new Edge(nextNode, distance[nextNode]));
					}
				}
			}
		}
		return distance[end];
	}
	
	
	
	

}
