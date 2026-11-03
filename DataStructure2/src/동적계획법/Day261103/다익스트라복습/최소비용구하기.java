package 동적계획법.Day261103.다익스트라복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	
	static ArrayList<Node>[] a;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		
		a = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			a[u].add(new Node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		BFS(1, 5);
		
		System.out.println(dist[end]);
	}
	
	private static void BFS(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.idx == end) {
				break;
			}
			
			if(visited[now.idx]) {
				continue;
			}
			
			visited[now.idx] = true; 
			
			for(Node i : a[now.idx]) {
				if(dist[i.idx] > dist[now.idx] + i.value) {
					dist[i.idx] = dist[now.idx] + i.value; 
					pq.add(new Node(i.idx, dist[i.idx]));
				}
			}
		}
	}

	
	private static class Node implements Comparable<Node> {
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
