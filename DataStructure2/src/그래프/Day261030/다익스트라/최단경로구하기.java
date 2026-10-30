package 그래프.Day261030.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로구하기 {
	static ArrayList<Node>[] a;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드수
		int m = Integer.parseInt(st.nextToken()); // 에지수
		int k = Integer.parseInt(br.readLine()); // 출발점
		
		visited = new boolean[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		a = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			a[u].add(new Node(v, w));
		}
		
		dijkstra(k); // 시작번호
		
		for (int i=1; i<=n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
		
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.end]) {
				continue;
			}
			visited[now.end]= true;
			
			for (Node next : a[now.end]) {
				if(dist[next.end] > dist[now.end] + next.value) {
					dist[next.end]= dist[now.end] + next.value;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
			
		}
		
	}
	
	private static class Node implements Comparable<Node>{
		int end;
		int value;
		Node(int end, int value) {
			this.end = end;
			this.value = value;
		}
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.value, n.value);
		}
	}

}
