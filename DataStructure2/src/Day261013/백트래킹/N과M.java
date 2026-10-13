package Day261013.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
	static int[] number;
	static boolean[] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 1~n까지
		m = Integer.parseInt(st.nextToken()); // m개 고르기
		
		number = new int[n]; // 수 저장
		visited = new boolean[n]; // 방문 처리
		
		backtracking(0); // 길이
		
	}
	
	public static void backtracking(int length) {
		if (length == m) {
			for (int i=0; i<m; i++) {
				System.out.print(number[i] + 1 + " ");
			}
			System.out.println();
		}
		
		for (int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				number[length] = i;
				backtracking(length + 1);
				visited[i] = false;
			}
		}
	}

}
