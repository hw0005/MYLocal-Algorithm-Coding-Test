package Day261019.백트래킹복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
	static int[] s = {0, 5, 5, 5, 5, 5};
	static int[][] miro;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		miro = new int[10][10];
		
		for (int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<10; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0, 0);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
	
	private static void backtracking(int xy, int useCnt) {
		if (xy == 100) {
			result = Math.min(result, useCnt);
			return;
		}
		
		if (result <= useCnt) {
			return;
		}
		
		int x = xy % 10;
		int y = xy / 10;
		
		if(miro[y][x] == 1) {
			for (int i=5; i>0; i--) {
				if(s[i]>0 && check(x, y, i)) {
					s[i]--;
					fill (x, y, i, 0);
					backtracking(xy+1, useCnt+1);
					s[i]++;
					fill(x, y, i, 1);
				}
			}
		}
		else {
			backtracking(xy+1, useCnt);
		}
	}
	private static void fill(int x, int y, int size, int num) {
		for (int i=y; i<y+size; i++) {
			for (int j=x; j<x+size; j++) {
				miro[i][j] = num;
			}
		}
	}
	
	private static boolean check(int x, int y, int size) {
		if(x+size >10 || y+size > 10) {
			return false;
		}
		for (int i=y; i<y+size; i++) {
			for (int j=x; j<x+size; j++) {
				if (miro[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

}
