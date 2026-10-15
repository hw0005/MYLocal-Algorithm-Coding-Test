package Day261015.백트래킹복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUEEN배치하기 {
	static int[] a;
	static int count;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		count = 0;
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
	private static boolean check(int row) {
		for (int i=0; i<row; i++) {
			if(a[row] == a[i]) {
				return false;
			}
			if (Math.abs(row-i) == Math.abs(a[i]-a[row])) {
				return false;
			}
		}
		return true;
	}

}
