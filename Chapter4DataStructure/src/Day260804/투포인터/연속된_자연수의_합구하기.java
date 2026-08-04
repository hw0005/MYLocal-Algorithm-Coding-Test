package Day260804.투포인터;

import java.util.Scanner;

public class 연속된_자연수의_합구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int startIdx = 1;
		int endIdx = 1;
		int count = 1;
		int sum = 1;
		
		
		while (endIdx != n) {
			if (sum == n) {
				count++;
				endIdx++;
				sum += endIdx;
			}
			else if (sum > n) {
				sum -= startIdx;
				startIdx++;
			}
			else {
				endIdx++;
				sum += endIdx;
			}
		}
		System.out.println(count);
		
	}

}
