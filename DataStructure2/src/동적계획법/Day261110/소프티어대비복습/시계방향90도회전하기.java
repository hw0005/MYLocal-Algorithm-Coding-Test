package 동적계획법.Day261110.소프티어대비복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시계방향90도회전하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 3
		int m = Integer.parseInt(st.nextToken()); // 4

		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1번 회전: 시계 방향 90도 (3x4 -> 4x3)
		int[][] r90 = rotate90(board);

		// 2번 회전: 180도 (4x3 -> 3x4)
		int[][] r180 = rotate90(r90);

		// 3번 회전: 시계 270도 = 반시계 90도 (3x4 -> 4x3)
		int[][] r270 = rotate90(r180);

		System.out.println("=== 90도 (1번 회전) ===");
		printBoard(r90);

		System.out.println("=== 180도 (2번 회전) ===");
		printBoard(r180);

		System.out.println("=== 270도 / 반시계 90도 (3번 회전) ===");
		printBoard(r270);
	}

	// 시계 방향 90도 회전 전용 공통 메서드
	public static int[][] rotate90(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		int[][] rotated = new int[m][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				rotated[j][n - 1 - i] = board[i][j];
			}
		}
		return rotated;
	}

	// 출력 메서드 (board.length, board[i].length 사용으로 가변 크기 대응)
	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
