package Day261013.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUEEN배치하기 {
	static int n;
	static int[] a;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // n개 놓기 및 n X n
		a = new int[n];
		count = 0;
		backtracking(0);
		System.out.println(count);
	}
	
	private static void backtracking(int row) {
		if (row == n) {
			count++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			a[row] = i; // 배치
			
			if(check(row)) {
				backtracking(row + 1);
			}
		}
	}
	
	private static boolean check(int row) {
		for (int i=0; i<row; i++) {
			if(a[i] == a[row]) {
				return false;
			}
			if (Math.abs(row-i) == Math.abs(a[row]-a[i])) {
				return false;
			}
		}
		return true;
	}
}
