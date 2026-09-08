package Day260908.트리.트리알아보기복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 리프노드의개수구하기 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int answer = 0, deleteNode = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		visited = new boolean[n];
		int root  = 0;
		
		for (int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int s = Integer.parseInt(st.nextToken());
			
			if (s != -1) {
				list[s].add(i);
				list[i].add(s);
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
			DFS(root);
			System.out.println(answer);
		}
		
	}
	
	private static void DFS(int i) {
		visited[i] = true;
		boolean hasChild = false;
		for (int next : list[i]) {
			if (!visited[next] && next != deleteNode) {
				hasChild = true;
				DFS(next);
			}
		}
		if(!hasChild) {
			answer++;
		}
		
	}

}
