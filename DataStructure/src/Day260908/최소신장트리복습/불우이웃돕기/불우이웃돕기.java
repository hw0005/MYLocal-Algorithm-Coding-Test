package Day260908.최소신장트리복습.불우이웃돕기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 불우이웃돕기 {
	static int[] parent;
	static int n, sum;
	static PriorityQueue<Edge> queue;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<>();
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			char[] tempC = st.nextToken().toCharArray();
			for (int j=0; j<n; j++) {
				int temp = 0;
				if (tempC[j] >= 'a' && tempC[j] <= 'z') {
					temp = tempC[j] - 'a' + 1;
				}
				else if(tempC[j] >= 'A' && tempC[j] <='Z') {
					temp = tempC[j] - 'A' + 27;
				}
				sum +=temp;
				if (i!=j && temp != 0) {
					queue.add(new Edge(i, j, temp));
				}
			}
		}
		
		parent = new int[n];
		for (int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int usedEdge = 0;
		int result = 0;
		
		while(!queue.isEmpty()) {
			Edge now = queue.poll();
			if (find(now.s) != find(now.e)) {
				union(now.s, now.e);
				usedEdge++;
				result += now.v;
			}
		}
		if (usedEdge == n - 1) {
			System.out.println(sum-result);
		}
		
		
		
		
	}
	
	private static void union (int a, int b) {
		a = find(a);
		b = find(b);
		if (a!=b) {
			parent[b] = a;
		}
	}
	
	private static int find(int idx) {
		if (idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int s, e, v;
		Edge(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		public int compareTo(Edge e) {
			return this.v - e.v;
		}
	}

}
