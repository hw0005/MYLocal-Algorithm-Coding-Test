package 그래프.Day261028.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소신장트리구하기 {
	static PriorityQueue<Node> pq;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		parent = new int[v+1];
		pq = new PriorityQueue<>();
		
		for (int i=1 ;i<=v; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.add(new Node(start, end, value));
		}
		
		int usedEdge = 0;
		int result = 0;
		
		while (usedEdge < v-1) {
			Node now = pq.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				usedEdge++;
				result +=now.value;
			}
		}
		
		System.out.println(result);
		
		
	}
	private static int find(int idx) {
		if (idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}

	private static class Node implements Comparable<Node>{
		int start;
		int end;
		int value;
		
		Node(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.value, n.value);
		}
		
	}
}
