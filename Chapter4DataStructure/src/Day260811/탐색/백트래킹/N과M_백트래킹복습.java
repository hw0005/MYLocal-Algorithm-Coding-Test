package Day260811.탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_백트래킹복습 {
	static int n, m;
	static boolean[] visited;
	static int[] s;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // N까지의 자연수 n
		m = Integer.parseInt(st.nextToken()); // 중복없이 m개 고름
		s = new int[n];
		visited = new boolean[n];
		
		backtracking(0);
	}
	
	private static void backtracking(int length) {
		if (length == m) {
			printArray();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) { // 방문하지 않은 숫자라면
				visited[i] = true;
				s[length] = i;
				backtracking(length + 1);
				visited[i] = false;
			}
		}
	}
	
	
	private static void printArray() {
		for (int i = 0; i < m; i++) {
			System.out.print(s[i] + 1 + " ");
		}
		System.out.println();
	}
	
	
}
