package Day260911.트리기본복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		answer = new int[n+1];
		visited = new boolean[n+1];
		
		
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
		
		DFS(1);
		for (int i=2; i< answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}
	
	private static void DFS(int number) {
		visited[number] = true;
		
		for (int next :tree[number]) {
			if (!visited[next]) {
				answer[next] = number;
				DFS(next);
			}
		}
		
	}
	


}
