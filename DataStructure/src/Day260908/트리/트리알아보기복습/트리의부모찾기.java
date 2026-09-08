package Day260908.트리.트리알아보기복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		answer = new int[n + 1];
		
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		DFS(1);
		for (int i=2; i<=n; i++) {
			System.out.println(answer[i]);
		}
	}
	
	private static void DFS(int start) {
		visited[start] = true;
		
		for (int next : list[start]) {
			// 방문하지 않은 노드 중에 지금 돌고 있는 게 너 부모야
			if (!visited[next]) {
				answer[next] = start;
				DFS(next);
			}
		}
	}
	


}
