package Day260810.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한소수찾기_DFS {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		DFS (2, 1);
		DFS (3, 1);
		DFS (5, 1);
		DFS (7, 1);
	}
	
	private static void DFS (int number, int jarisu) {
		// 자리수가 n이고 소수면 출력
		if (jarisu == n) {
			if (isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		
		// DFS 붙여가면서(잘라가면서) 확인하기
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) { // 짝수면 그 i번째 스킵
				continue;
			}
			// 홀수면, 그 다음 자릿수가 소수인지 확인. 그게 소수가 맞으면 (number * 10 + i, 자리수 + 1)로 재귀함수 하며 자리수 늘리기
			if (isPrime(number * 10 + i)) {
				DFS(number * 10 + i, jarisu + 1);
			}
		}
	}
	
	// 소수 = 2부터시작해서, 들어온 수 / 2까지 + 들어온수 / 모든 수가 만약 나머지가 0이 아니라면 소수임
	private static boolean isPrime (int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	

}
