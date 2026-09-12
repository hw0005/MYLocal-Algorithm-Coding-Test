package Day260912.트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 리프노드의개수구하기 {
	static int deleteNode = 0, answer = 0;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 노드 개수
		
		tree = new ArrayList[n];
		visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if (a == -1) {
				root = i;
			}
			else {
				tree[i].add(a);
				tree[a].add(i);
			}
		}
		
		
		deleteNode = Integer.parseInt(br.readLine()); // 삭제 노드
		
		
		
		if (root == deleteNode) {
			System.out.println(-1);
		}
		else {
			DFS(0);
			System.out.println(answer);
		}
	}
	
	private static void DFS(int num) {
		visited[num] = true;
		boolean haschild = false;
		
		for (int next : tree[num]) {
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
