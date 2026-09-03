package Day260903.최소신장트리복습.최소신장트리구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소신장트리구하기 {

	static int[] parent;
	static PriorityQueue<Edge> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		
		parent = new int[n + 1];
		queue = new PriorityQueue<>();
		
		for (int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			queue.add(new Edge(s, e, v));

		}
		
		int usedEdge = 0;
		int result = 0;
		
		while (usedEdge < n - 1) {
			Edge now = queue.poll();
			if (find(now.start)!= find(now.end)) {
				union(now.start, now.end);
				result += now.value;
				usedEdge++;
			}
		}
		System.out.println(result);
		
	}
	
	private static void union(int a, int b) {
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

}
