package Day261012.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수구하기 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		int count = 0;
		for (int i=1; i<=n; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println(count);

	}
	private static void DFS(int idx) {
		if(visited[idx]) {
			return;
		}
		
		visited[idx] = true;
		for (int i: list[idx]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

}
