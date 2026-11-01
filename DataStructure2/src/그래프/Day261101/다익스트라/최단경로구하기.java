package 그래프.Day261101.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로구하기 {
	static boolean[] visited;
	static ArrayList<Node>[] a;
	static int[] dist;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		int k = Integer.parseInt(br.readLine()); // 시작번호
		
		a = new ArrayList[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		visited = new boolean[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			a[u].add(new Node(v,w));
		}
		
		BFS(k); // 시작 노드 번호
		
		for (int i=1; i<=n; i++) {
			if (!visited[i]) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
		
	}
	
	private static void BFS(int num) { // 시작 노드 번호
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(num, 0));
		dist[num] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll(); // 시작 노드 꺼내기
			int nowNode = now.idx; // 지금 노드 번호
			
			if(visited[nowNode]) {
				continue;
			}
			
			visited[nowNode] = true;
			
			for (Node next : a[nowNode]) {
				if(dist[next.idx] > dist[nowNode]+ next.value) {
					dist[next.idx]= dist[nowNode] + next.value;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
		
	}
	
	private static class Node implements Comparable<Node>{
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
