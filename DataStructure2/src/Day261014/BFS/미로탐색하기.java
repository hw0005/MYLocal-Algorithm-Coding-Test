package Day261014.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색하기 {
	// 좌하우상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int n, m;
	
	static int[][] a;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			for (int j=0; j<m; j++) {
				a[i][j] = line.charAt(j) - '0';
			}
		}
		
		BFS(0, 0); // 좌표 i, j
		System.out.println(a[n-1][m-1]);
	}
	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int k=0; k<4; k++) {
				int nr = dx[k] + now[0];
				int nc = dy[k] + now[1];
				
				if (nr>=0 && nc>=0 && nr<n && nc<m) {
					if (a[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
						a[nr][nc] = a[now[0]][now[1]] + 1;
					}
				}
				
			}
			
			
			
			
		}
	}
}
