package Day260811.탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen배치하기_백트래킹 {
	static int n; // n X n 체스판
	static int[] a; // 퀸의 자리 정보 저장 배열
	static int count = 0; // 몇 개인지 셀 거임(출력)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 초기화
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		
		// 백트래킹
		backtracking(0); // 0행부터 시작
		
		System.out.println(count);
		
	}
	
	private static void backtracking(int row) {
		// 3. 정답 도출
		if (row == n) {
			count++;
			return;
		}
		
		// 1. 모든 유형 탐색
		for (int i = 0; i < n; i++) {
			a[row] = i; // 퀸 자리 배치
			// 2. 가지치기: 직선, 대각선 공격 가능 시 그걸 제외해
			if (check(row)) { // 매개변수 row들어가 왜냐면 이걸로 다 조회 가능함. 이게 true: 공격 X, false: 공격 O. 공격 X일 때만 다음 퀸의 자리 배치하기
				backtracking(row + 1); // 행 검사. 같은 행도 안 됨 직선을 막아놨다 왜냐면 다음 행 들어가게 했기 때문
				
				// 아래 3줄도 됨. 하나 체크해서 올리고, 아니면 내리고
//				row += 1;
//				backtracking(row);
//				row -= 1;
			}
		}
		
	}
	
	private static boolean check(int row) {
		// 모든 경우 탐색, 이전에 미리 배치해둔 아이들과 비교
		for (int i = 0; i < row; i++) {
			// 열 직선 공격 가능시 false;
			if (a[row] == a[i]) {
				return false;
			}
			// 대각선 공격 가능 시 false; (행 - 행) == (열 - 열) -> 
			if (Math.abs(row - i) == Math.abs(a[row] - a[i])) {
				return false;
			}
		}
		// 다 아니라면 true
		return true;
	}
}
