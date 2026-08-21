package Day260821.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_소수복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] a = new int[n + 1];
		// 값넣기
		for (int i = 2; i <= n; i++) {
			a[i] = i;
		}
	
		// 소수 로직 시작
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (a[i] == 0) { // 배수로 이미 나눠져서 0으로 됐다면
				continue; // 다음 거 탐색
			}
			for (int j = i + i; j <= n; j = j + i) { // 배수 지우기
				a[j] = 0;
			}
		}
		for (int i = m; i<=n; i++) {
			if(a[i] != 0) {
				System.out.println(a[i]);
			}
		}
		
	}

}
