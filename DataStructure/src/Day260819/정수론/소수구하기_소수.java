package Day260819.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 시작 수
		int n = Integer.parseInt(st.nextToken()); // 마지막 수
		int[] a = new int[n + 1];
		
		// 값저장
		for (int i = 2; i <= n; i++) {
			a[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (a[i] == 0) {
				continue;
			}
			// 소수의 배수들 싹 다 0 처리
			for (int j = i + i; j <= n; j += i) {
				a[j] = 0;
			}
		}
		for (int i = m; i <= n; i++) {
			if (a[i] != 0) {
				System.out.println(a[i]);
			}
		}
		
	}

}
