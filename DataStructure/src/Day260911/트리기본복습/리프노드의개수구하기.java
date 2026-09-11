package Day260911.트리기본복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 리프노드의개수구하기 {
	static boolean[] visited;
	static int deleteNode = 0;
	static int answer = 0;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 노드 수
		
		visited = new boolean[n];
		tree = new ArrayList[n];
		
		for (int i=0; i<n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		int root = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if (parent == -1) {
				root = i;
			}
			else {
				tree[i].add(parent);
				tree[parent].add(i);
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		
		if (deleteNode == root) {
			System.out.println(0);
		} else {
			DFS(root);
			System.out.println(answer);
		}
	}
	
	private static void DFS(int root) {
		visited[root] = true;
		boolean haschild = false;
		
		for (int next : tree[root]) {
			if (!visited[next] && next != deleteNode) {
				haschild = true;
				DFS(next);
			}
		}
		if (!haschild) {
			answer++;
		}
		
		
	}

}
