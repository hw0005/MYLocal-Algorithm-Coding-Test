package Day260811.탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_백트래킹 {
	// 10X10 배열 1개, 색종이개수 담을 배열 1개, result(출력용) 1개
	static int[][] m = new int[10][10];
	static int[] s = {0, 5, 5, 5, 5, 5};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 넣기
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// backtracking(좌표, 종이 몇 개 쓴지 count)
		backtracking(0, 0);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
	}
	
	// backtracking(색종이 전체 메서드), fill(붙였다 뗐다 하는 메서드), check(이거 붙일 수 있어? 못 붙이면)
	private static void backtracking(int xy, int useCount) {
		if (xy == 100) {
			result = Math.min(result, useCount);
			return;
		}
		
		int x = xy % 10;
		int y = xy / 10;
		
		// useCount >= result -> 즉 지금 돌고 있는 그게 result보다 크면 더 이상의미없음 시간복잡도만 올라
		if (useCount >= result) {
			return;
		}
		
		// 1일 (붙여야 할) 때
		if (m[y][x] == 1) {
			// check 함수 + 색종이 개수 남음?
			for (int i = 5; i > 0; i--) {
				if (s[i] > 0 && check(x, y, i)) { // 가능이면
					s[i]--;
					fill(x, y, 0, i); // 0으로 바꾸고(붙여) size 만큼 추가
					backtracking(xy + 1, useCount + 1); // 거기 다 돌아
					s[i]++;
					fill(x, y, 1, i); // 안되면 1로 바꾸고(떼고) size 만큼 삭제
					
				}
				
			}
		}
		// 0일 때는 그냥 좌표만
		else {
			backtracking(xy + 1, useCount);
		}
	} // b함수 끝
	
	private static void fill (int x, int y, int num, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) { 
				m[i][j] = num;
			}
		}
	} // fill 함수끝
	
	private static boolean check(int x, int y, int size) {
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
	} // check 함수 끝
	

}
