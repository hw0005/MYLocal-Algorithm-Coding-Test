package Day261001.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n+1];
		
		String numbers = br.readLine();
		for (int i=1; i<=n; i++) {
			ans[i] = numbers.charAt(i-1) - '0';
		}
		
		int sum = 0;
		
		for (int i=1; i<=n; i++) {
			sum += ans[i];
		}
		
		
		System.out.println(sum);
		
	}

}
