package Day260811.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색하기_BFS {
	// 방문확인 2차원배열 visited, 값담을 2차원배열, n&m int, 움직이는 1차원배열 2개 dx&dy
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] a;
	static boolean[][] visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
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
		
		// BFS 실행
		BFS(0, 0); // 0,0부터 시작
		// 출력
		System.out.println(a[n-1][m-1]);
		
	}
	
	private static void BFS(int i, int j) {
		// 초기값 선언
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll(); // 배열 1개 뽑음
			// for문 돌면서 좌표 제한 설정
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				// 좌표 제한 + 0 이 아닐 때, 방문한 적 없을 때 저장
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (a[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						a[x][y] = a[now[0]][now[1]] + 1;
						queue.offer(new int[] {x, y});
					}
				}
			}
		}
		
		
	}
}
