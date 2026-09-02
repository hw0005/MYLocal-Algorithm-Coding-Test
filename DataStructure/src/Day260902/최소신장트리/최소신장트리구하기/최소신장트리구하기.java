package Day260902.최소신장트리.최소신장트리구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소신장트리구하기 {
	static PriorityQueue<Edge> edges;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 노드 수
		int e = Integer.parseInt(st.nextToken()); // 에지 수
		
		// 초기화
		edges = new PriorityQueue<>();
		parent = new int[v + 1];
		
		for (int i = 1; i<=v; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(start, end, value));
		}
		
		int sum = 0;
		int usedEdge = 0;
		
		while (usedEdge < v - 1) {
			Edge now = edges.poll();
			
			
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end); 
				sum += now.value;
				usedEdge++;
			}
		}
		
		System.out.println(sum);
		
		
		
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
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

}
