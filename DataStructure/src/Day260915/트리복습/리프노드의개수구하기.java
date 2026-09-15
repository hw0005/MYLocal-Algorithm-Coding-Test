package Day260915.트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 리프노드의개수구하기 {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int deleteNode = 0, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		tree = new ArrayList[n];
		
		for (int i=0; i<n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int p = Integer.parseInt(st.nextToken());
			
			if (p != -1) {
				tree[i].add(p);
				tree[p].add(i);
			}
			else {
				root = i;
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		
		if (deleteNode == root) {
			System.out.println(0);
		}
		else {
			DFS(0);
			System.out.println(answer);
		}
		
		
	}
	
	private static void DFS(int num) {
		visited[num] = true;
		boolean hasChild = false;
		
		for (int next : tree[num]) {
			if (!visited[next] && deleteNode != next) {
				hasChild = true;
				DFS(next);
			}
		}
		if (!hasChild) {
			answer++;
		}
	}

}
