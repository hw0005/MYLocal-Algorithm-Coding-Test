package Day260912.최소공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소공통조상구하기 {
	static ArrayList<Integer>[] tree;
	static int[] parent;
	static int[] depth;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		parent = new int[n+1];
		depth = new int[n+1];
		visited = new boolean[n+1];
		
		BFS(1);
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			System.out.println(LCA(s, e));
			
		}
		
		
	}
	
	private static int LCA (int a, int b) {
		if(depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(depth[a] != depth[b]) {
			a = parent[a];
		}
		
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		int level = 1;
		int nowSize = 1;
		int count = 0;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int next : tree[nowNode]) {
				
				if (!visited[next]) {
					visited[next] = true;
					parent[next] = nowNode;
					depth[next] = level;
					queue.add(next);
					
				}
			}
			
			count++;
			
			if (count == nowSize) {
				count = 0; // 초기화
				nowSize = queue.size(); // 사이즈 만큼 넣어 노드 수
				level++; // depth ++
			}
		}
		
		
	}


}
