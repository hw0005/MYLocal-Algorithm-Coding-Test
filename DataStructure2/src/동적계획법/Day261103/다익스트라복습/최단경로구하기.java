package 동적계획법.Day261103.다익스트라복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로구하기 {
	static ArrayList<Node>[] a;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 노드
		int e = Integer.parseInt(st.nextToken()); // 에지
		
		int k = Integer.parseInt(br.readLine()); // 출발점
		
		a = new ArrayList[v+1];
		visited = new boolean[v+1];
		dist = new int[v+1];
		for (int i=1; i<=v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i=1; i<=v; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=1; i<=e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			a[start].add(new Node(end,value));
		}
		BFS(k);
		
		for (int i=1; i<=v; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
	}
	
	private static void BFS(int num) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(num, 0));
		dist[num] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.idx]) {
				continue;
			}
			visited[now.idx]= true;
			
			for (Node i : a[now.idx]) {
				if(dist[i.idx] > dist[now.idx] + i.value) {
					dist[i.idx] = dist[now.idx] + i.value;
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
