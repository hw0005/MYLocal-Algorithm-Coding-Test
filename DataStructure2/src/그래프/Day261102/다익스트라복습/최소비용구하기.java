package 그래프.Day261102.다익스트라복습;

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
		
		dist = new int[n+1];
		for (int i=1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		a = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		visited = new boolean[n+1];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			a[start].add(new Node(end, value));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작 도시
		int end = Integer.parseInt(st.nextToken()); // 도착 도시
		
		int answer = BFS(start, end);
		
		System.out.println(answer);
	}
	
	private static int BFS(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (now.idx == end) {
				return now.value;
			}
			
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
		return -1;
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
