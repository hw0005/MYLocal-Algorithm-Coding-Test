package 동적계획법.Day261103.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회경로짜기 {

	static int n;
	static int[][] map;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); // 도시 수
		
		map = new int[n][n];
		visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		visited[0] = true;
		
		
		DFS(0, 1, 0); // 출발도시, 방문한 도시 횟수, 누적비용
		System.out.println(min);
		
	}
	
	private static void DFS(int now, int count, int cost) {
		if(cost >= min) {
			return;
		}
		
		if (count == n) {
			if(map[now][0] != 0) {
				min = Math.min(min, map[now][0] + cost);
			}
			return;
		}
		
		// 다음 갈 도시 탐색
		for (int next=0; next<n; next++) {
			if(!visited[next] && map[now][next] != 0) {
				visited[next] = true;
				DFS(next, count + 1, cost + map[now][next]);
				visited[next] = false;
			}
		}
		
		
	}

}
