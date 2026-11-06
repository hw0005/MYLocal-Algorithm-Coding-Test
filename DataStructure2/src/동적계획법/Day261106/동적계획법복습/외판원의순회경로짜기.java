package 동적계획법.Day261106.동적계획법복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원의순회경로짜기 {
	static int[][] map;
	static int min;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		min = Integer.MAX_VALUE;
		visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		DFS(0, 1, 0);
		System.out.println(min);
		
	}
	
	private static void DFS(int now, int count, int cost) {
		if (cost>=min) {
			return;
		}
		
		if (count == n) {
			if(map[now][0] != 0) {
				min = Math.min(min, cost + map[now][0]);
			}
			return;
		}
		
		
		for (int next=0; next<n; next++) {
			if(!visited[next] && map[now][next] != 0) {
				visited[next] = true;
				DFS(next, count + 1, cost + map[now][next]);
				visited[next] = false;
			}
		}
	}
}
