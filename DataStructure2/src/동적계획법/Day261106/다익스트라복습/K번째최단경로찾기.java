package 동적계획법.Day261106.다익스트라복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {
	static ArrayList<Node>[] a;
	static PriorityQueue<Integer>[] dist;
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n+1];
		dist = new PriorityQueue[n+1];
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			a[start].add(new Node(end, value));
		}
		
		dijkstra(1);
		for (int i=1; i<=n; i++) {
			if(dist[i].size() == k) {
				System.out.println(dist[i].poll());
			}
			else {
				System.out.println(-1);
			}
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start].add(0);
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for (Node next : a[now.idx]) {
				int cost = now.value + next.value;
				
				if(dist[next.idx].size() < k) {
					dist[next.idx].add(cost);
					pq.add(new Node(next.idx, cost));
				}
				else if(dist[next.idx].peek() > cost) {
					dist[next.idx].poll();
					dist[next.idx].add(cost);
					pq.add(new Node(next.idx, cost));
				}
			}
		}
	}
	
	private static class Node implements Comparable <Node>{
		int idx;
		int value;
		Node(int idx, int value){
			this.idx = idx;
			this.value = value;
		}
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.value, n.value);
		}
	}

}
