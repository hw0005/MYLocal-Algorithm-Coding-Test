package 동적계획법.Day261104.다익스트라복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로구하기 {
	static ArrayList<Node>[] a;
	static PriorityQueue<Integer>[] dist;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // k번째 최단경로
		
		a = new ArrayList[n+1];
		dist = new PriorityQueue[n+1];
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			a[u].add(new Node(v, w));
		}

		BFS(1, k);
		
		for (int i=1; i<dist.length; i++) {
			if(dist[i].size() == k) {
				System.out.println(dist[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
	}
	
	private static void BFS(int start, int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start].add(0);
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(Node next : a[now.idx]) {
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
