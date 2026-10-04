package Day261004.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sIdx = 1;
		int eIdx = 1;
		int count = 1;
		int sum = 1;
		while (eIdx != n){ 
			if (sum == n) {
				count++;
				eIdx++;
				sum += eIdx;
			}
			else if (sum > n) {
				sum -= sIdx;
				sIdx++;
			}
			else {
				eIdx++;
				sum += eIdx;
			}
		
		}
		System.out.println(count);
	}

}
