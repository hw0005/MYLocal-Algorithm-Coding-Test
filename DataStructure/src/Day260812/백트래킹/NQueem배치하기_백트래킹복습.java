package Day260812.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueem배치하기_백트래킹복습 {
	// 담을 1차원 배열 1개, 입력받을 수 n, count
	static int count = 0;
	static int n;
	static int[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		
		// 백트래킹
		backtracking(0);
		
		System.out.println(count);
	}
	
	private static void backtracking(int row) {
		
		// 3. 정답 도출
		if (row == n) {
			count++;
			return;
		}
			
		// 1. 전체 경우 탐색
		for (int i = 0; i < a.length; i++) {
			a[row] = i; // 퀸 하나 배치
			// 2. 가지치기 : 직선(행, 열), 대각선
			if (check(row)) {
				backtracking(row + 1);
			}
		
		}
			
	}
	private static boolean check(int row) {
		// 모든 경우 탐색 미리 배치와 비교
		for (int i = 0; i < row; i++) {
			// 열공격
			if (a[row] == a[i]) {
				return false;
			}
			// 대각선 공격
			if (Math.abs(row - i) == Math.abs(a[row] - a[i])) {
				return false;
			}
		}
		return true;
	}

}
