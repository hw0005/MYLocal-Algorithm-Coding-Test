package Day261016.백트래킹복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUEEN배치하기 {
	static int[] a;
	static int n;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		backtracking(0);
		System.out.println(count);
	}
	
	private static void backtracking(int row) {
		if (row == n) {
			count++;
			return;
		}
		for (int i=0; i<n; i++) {
			a[row] = i;
			
			if (check(row)) {
				backtracking(row + 1);
			}
		}
	}
	
	private static boolean check (int row) {
		for (int i=0; i<row; i++) {
			if (a[row] == a[i]) {
				return false;
			}
			if (Math.abs(row-i) == Math.abs(a[row] - a[i])) {
				return false;
			}
		}
		return true;
	}

}
