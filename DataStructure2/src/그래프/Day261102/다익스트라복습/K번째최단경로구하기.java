package 그래프.Day261102.다익스트라복습;

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
		int k = Integer.parseInt(st.nextToken()); // K 번째 최단경로
		
		a = new ArrayList[n+1];
		dist = new PriorityQueue[n+1];
		
		for (int i=1; i<=n; i++) {
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			a[u].add(new Node(v, w));
		}
		
		dijkstra(1, k);
		
		for (int i=1; i<=n; i++) {
			if(dist[i].size() == k) {
				System.out.println(dist[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
		
	}
	
	private static void dijkstra(int start, int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start].add(0);
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int nowIdx = now.idx;
			int nowValue = now.value;
			
			for (Node next : a[now.idx]) {
				int nextIdx = next.idx;
				int nextValue = next.value;
				
				if(dist[nextIdx].size() < k) { // 사이즈 작으면 무조건 넣기
					dist[nextIdx].add(nowValue + nextValue);
					pq.add(new Node(nextIdx, nowValue + nextValue));
				}
				else if (dist[nextIdx].peek() > nowValue + nextValue) { // 제일 큰 값 > 지금 들어가는 값 --> 큰 값 빼기
					dist[nextIdx].poll();
					dist[nextIdx].add(nowValue + nextValue);
					pq.add(new Node(nextIdx, nowValue + nextValue));
				}
			}
			
			
		}
		
		
		
	}
	
	private static class Node implements Comparable<Node>{
//		int start;
		int idx;
		int value;
		Node(int idx, int value) {
//			this.start = start;
			this.idx = idx;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.value, n.value); // 내림차순으로 해서 poll하자
		}
	}
}
