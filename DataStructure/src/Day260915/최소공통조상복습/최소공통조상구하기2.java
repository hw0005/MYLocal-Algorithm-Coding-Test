package Day260915.최소공통조상복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소공통조상구하기2 {
	static int[][] parent;
	static boolean[] visited;
	static int[] depth;
	static ArrayList<Integer>[] tree;
	static int kmax;
	
	public static void main(String[] args) throws IOException{
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
		
		depth = new int[n+1];
		visited = new boolean[n+1];
		
		kmax = 0;
		int temp = 1;
		while (temp <= n) {
			temp *= 2;
			kmax++;
		}
		parent = new int[kmax+1][n+1];
		BFS(1);
		for (int k=1; k<=kmax; k++) {
			for (int i=1; i<=n; i++) {
				parent[k][i] = parent[k-1][parent[k-1][i]];
			}
		}
		
		
		
		int m = Integer.parseInt(br.readLine());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			System.out.println(LCA(s, e));
		}
	}
	
	private static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		// 깊이 맞추기
		for (int k=kmax; k>=0; k--) {
			if (Math.pow(2, k) <= depth[a] - depth[b]) {
				if (depth[b] <= depth[parent[k][a]]) {
					a = parent[k][a];
				}
			}
		}
		
		// 최소공통부모 1칸 밑까지, 부모가 다르면 타고 올라가
		for (int k=kmax; k>=0;k--) {
			if (parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		if (a!=b) {
			a = parent[0][a];
			b = parent[0][b];
		}
		
		return b;
	}
	
	private static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;
		depth[num] = 1;
		
		int level = 2;
		int nowSize = 1;
		int count = 0;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int next : tree[nowNode]) {
				if (!visited[next]) {
					visited[next] = true;
					depth[next] = level;
					parent[0][next] = nowNode;
					queue.add(next);
				}
			}
			
			count++;
			
			if (count == nowSize) {
				count = 0;
				nowSize = queue.size();
				level++;
			}
		}
	}

}
