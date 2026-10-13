package Day261013.DFS복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 신기한소수찾기 {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 자릿수 n
		
		DFS(2, 1); // 일의자리에서 소수, 자릿수 1
		DFS(3, 1); // 일의자리에서 소수, 자릿수 1
		DFS(5, 1); // 일의자리에서 소수, 자릿수 1
		DFS(7, 1); // 일의자리에서 소수, 자릿수 1
		
	}
	private static void DFS(int num, int jarisu) {
		if (jarisu == n) {
			if (isPrime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		for (int i=1; i<10; i++) {
			if(i%2==0) { // 짝수면 다음
				continue;
			}
			if (isPrime(num * 10 + i)) {
				DFS(num * 10 + i, jarisu + 1);
			}
		}
	}
	
	private static boolean isPrime(int num) {
		for (int i=2; i<=num/2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
