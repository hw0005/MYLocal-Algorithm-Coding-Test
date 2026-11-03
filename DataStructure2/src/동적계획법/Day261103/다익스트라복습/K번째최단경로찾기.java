package 동적계획법.Day261103.다익스트라복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {
	
	static ArrayList<Node>[] a; 
	static PriorityQueue<Integer>[] dist; // 거리를 담는 거 == 내림차순
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n+1];
		dist = new PriorityQueue[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] =new ArrayList<>();
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			a[start].add(new Node(end, value));
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
		dist[start].add(0);
		pq.add(new Node(start, 0));
		
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			int nowIdx = now.idx;
			int nowVal = now.value;
			
			for (Node next : a[nowIdx]) {
				int nextIdx = next.idx;
				int nextVal = next.value;
				
				if(dist[nextIdx].size() < k) { // 들어온 수가 k보다 사이즈가 작으면 무조건 넣기
					dist[nextIdx].add(nowVal + nextVal);
					pq.add(new Node(nextIdx, nowVal + nextVal));
				}
				else if(dist[nextIdx].peek() > nowVal + nextVal) { // k보다 크면 확인 크면, 값 봐서 빼기
					dist[nextIdx].poll();
					dist[nextIdx].add(nowVal + nextVal);
					pq.add(new Node(nextIdx, nowVal + nextVal));
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
			return Integer.compare(this.value, n.value); // 오름차순으로 꺼내기
		}
	}

}
