package Day261014.백트래킹복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
	static int[] s; // 답 담을 것
	static int n, m;
	static boolean[] v;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 1~n까지의 자연수
		m = Integer.parseInt(st.nextToken()); // m개 고름
		
		s = new int[n];
		v = new boolean[n];
		backtracking(0);
	}
	
	private static void backtracking(int length) {
		if (length == m) {
			for (int i=0; i<m; i++) {
				System.out.print(s[i] + 1 + " ");
			}
			count++;
			System.out.println();
			System.out.println(count);
			return;
		}
		
		for (int i=0; i<n; i++) {
			if(!v[i]) {
				v[i] = true;
				s[length] = i;
				backtracking(length + 1);
				v[i] = false;
			}
		}
	}

}
