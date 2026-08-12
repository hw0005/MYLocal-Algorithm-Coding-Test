package Day260812.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_백트래킹복습 {
	// 색종이 10 x 10 2차원 1개, 색종이개수 담을 1차원 1개. 출력용 1개
	static int[][] m = new int[10][10];
	static int[] s = {0, 5, 5, 5, 5, 5};
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 넣기
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < 10; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 백트래킹: 좌표, 색종이 쓴 거 count
		backtracking(0, 0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
	
	private static void backtracking(int xy, int useCnt) {
		// 3. 정답 도출
		if (xy == 100) {
			result = Math.min(result, useCnt);
			return;
		}
		
		int x = xy % 10;
		int y = xy / 10;
		
		//useCnt >= result면 더 탐색할 필요도 없음
		if (useCnt >= result) {
			return;
		}
		// 1. 모든 조건 탐색
		
		// 1. 1일 때 붙여야지
		if (m[y][x] == 1) {
			for (int i = 5; i > 0; i--) {
				if (s[i] > 0 && check(x, y, i)) {
					s[i]--;
					fill(x, y, i, 0); // 우선 0으로 채우고
					backtracking(xy + 1, useCnt + 1);
					s[i]++;
					fill(x, y, i, 1); // 없으면 1로 다시 채우기 
				}
			}
			
		
		}
		
		// 0일 때
		else {
			backtracking(xy + 1, useCnt); // 좌표만
		}
		
		
	}
	private static void fill(int x, int y, int size, int num) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				m[i][j] = num;
			}
		}
	}
	
	private static boolean check (int x, int y, int size) {
		if (x + size > 10 || y + size > 10) {
			return false;
		}
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (m[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

}
