package 그래프.Day261101.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static ArrayList<Node>[] a;
	static boolean[] visited;
	static int[] dist;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		
		visited = new boolean[n+1];
		a = new ArrayList[n+1];
		dist = new int[n+1];
		for (int i=1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
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
		
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		dijkstra(startCity, endCity);
		
		System.out.println(answer);
	}
	private static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nowNode = now.idx;
			
			if(nowNode == end) {
				answer = now.value;
				return;
			}
			
			if(visited[nowNode]) {
				continue;
			}
			visited[nowNode] = true;
			
			for (Node i: a[nowNode]) {
				if(dist[i.idx] > dist[nowNode] + i.value) {
					dist[i.idx] = dist[nowNode] + i.value;
					pq.add(new Node(i.idx, dist[i.idx]));
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
