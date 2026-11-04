package 동적계획법.Day261104.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원의순회경로짜기 {
	
	static int[][] map;
	static boolean[]visited;
	static int min, n;
	
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
		DFS(0, 1, 0); // 시작 도시, 센 횟수, 비용
		System.out.println(min);
	}
	
	private static void DFS(int now, int count, int cost) {
		if(cost>=min) {
			return;
		}
		
		if(count == n) { // 도달 했으면
			// 그 값에서 출발도시로 돌아갈 수 있는지 확인
			if(map[now][0] != 0) {
				min = Math.min(min, cost + map[now][0]);
			}
			return;
		}
		
		for (int next = 0; next<n; next++) {
			if(!visited[next] && map[now][next] != 0) {
				visited[next] = true;
				DFS(next, count + 1, cost + map[now][next]);
				visited[next] = false;
			}
		}
	}
}
