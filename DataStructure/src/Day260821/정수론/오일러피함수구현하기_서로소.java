package Day260821.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오일러피함수구현하기_서로소 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long count = n;
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) { // 소인수(나눠지는 수라면)
				count = count - count / i;
				while (n % i == 0) {
					n = n / i;
				}
			}
		}
		if (n > 1) {
			count = count - count / n;
		}
		System.out.println(count);
		
	}

}
