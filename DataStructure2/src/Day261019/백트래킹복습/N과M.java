package Day261019.백트래킹복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
	static int n, m;
	static boolean[] visited;
	static int[] s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		s = new int[n];
		
		backtracking(0);
		
	}
	
	public static void backtracking(int length) {
		if (length == m) {
			for (int i=0; i<m; i++) {
				System.out.print(s[i] + 1 + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				s[length] = i;
				backtracking(length+1);
				visited[i] = false;
			}
		}
		
		
	}

}
