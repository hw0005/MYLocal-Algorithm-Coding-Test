package Day260814.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색하기_BFS복습 {
	// dx&dy 1개, visited 2차원, 담을 배열 a 1차원, 값 읽기 n & m,
	static boolean[][] visited;
	static int[][] a;
	static int n, m;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 초기화
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		visited = new boolean[n][m];
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		
		BFS(0, 0); // i, j
		System.out.println(a[n-1][m-1]);
	}
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if(a[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						a[x][y] = a[now[0]][now[1]] + 1;
						queue.offer(new int[] {x, y});
					}
				}
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
