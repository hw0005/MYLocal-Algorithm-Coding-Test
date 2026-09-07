package Day260907.트리알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 리프노드의개수구하기 {
	static int answer = 0, deleteNode = 0;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		// 초기화
		visited = new boolean[n];
		tree = new ArrayList[n];
		
		for (int i=0; i<n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		int root = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int s = Integer.parseInt(st.nextToken());
			
			if (s == -1) {
				root = i;
			}
			else {
				tree[i].add(s);
				tree[s].add(i);
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		DFS(root);
		
		System.out.println(answer);
	}
	
	private static void DFS(int parent) {
		visited[parent] = true;
		boolean hasChild = false;
		
		for (int child : tree[parent]) {
			if (!visited[child] && deleteNode != child) {
				hasChild = true;
				DFS(child);
			}
		}
		
		if (!hasChild) {
			answer++;
		}
		
		
	}


}
