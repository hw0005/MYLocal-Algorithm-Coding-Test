package Day261015.BFS복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색하기 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0 };

	static int[][] miro;
	static boolean[][] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // n
		m = Integer.parseInt(st.nextToken()); // m

		miro = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				miro[i][j] = line.charAt(j) - '0';
			}
		}

		BFS(0, 0); // 좌표

		System.out.println(miro[n - 1][m - 1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int k = 0; k < 4; k++) {
				// 움직인 좌표
				int nr = dr[k] + now[0];
				int nc = dc[k] + now[1];

				if (nr >= 0 && nc >= 0 && nr < n && nc < m) { // 좌표가 밖으로 벗어나지 않는 선에서
					if (!visited[nr][nc] && miro[nr][nc] == 1) { // 미로가 1로 돼있다면 전진
						visited[nr][nc] = true;
						miro[nr][nc] = miro[now[0]][now[1]] + 1;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}

	}
}
