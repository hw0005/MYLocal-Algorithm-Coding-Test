package Day260810.탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_백트래킹 {
	static int n, m;
	static boolean[] v; // 숫자 사용 여부 저장
	static int[] s; // 수열 정보 저장
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = new int[n];
		v = new boolean[n];
		backtracking(0);
		
	}
	
	private static void backtracking(int length) {
		if (length == m) { // 길이가 M인 수열ㅇ 만들어진 경우 출력
			printArray();
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i] = true;
				s[length] = i;
				backtracking(length + 1);
				v[i] = false;
			}
		}
	}
	
	private static void printArray() {
		// 쌓은 s배열 출력
		for (int i = 0; i < m; i++) {
			System.out.print(s[i] + 1 + " ");
		}
		System.out.println();
	}
	
	
}
