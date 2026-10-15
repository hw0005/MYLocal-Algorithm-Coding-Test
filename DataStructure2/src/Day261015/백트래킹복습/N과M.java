package Day261015.백트래킹복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
	static int[] answer;
	static int n, m;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 1~n까지의 자연 수 중
		m = Integer.parseInt(st.nextToken()); // 중복없이 m개를 고른 수열
		
		answer = new int[m];
		visited = new boolean[n];
		backtracking(0);
	}
	
	private static void backtracking(int length) {
		if (length == m) {
			for (int i=0; i<m; i++) {
				System.out.print(answer[i] + 1 + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer[length] = i;
				backtracking(length + 1);
				visited[i] = false;
			}
		}
	}

}
