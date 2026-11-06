package 동적계획법.Day261106.다익스트라복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로구하기 {
	static ArrayList<Node>[] a;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[v+1];
		dist = new int[v+1];
		visited = new boolean[v+1];
		
		for (int i=1; i<=v; i++) {
			a[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			a[start].add(new Node(end, value));
		}
		
		dijkstra(k);
		
		for (int i=1; i<=v; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
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
			
			if(visited[now.idx]) {
				continue;
			}
			visited[now.idx] = true;
			
			for (Node next : a[now.idx]) {
				if(dist[next.idx] > dist[now.idx] + next.value) {
					dist[next.idx] = dist[now.idx] + next.value;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}

	private static class Node implements Comparable<Node>{
		int idx;
		int value;
		Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.value, n.value);
		}
	}
}
