package Day261007.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int i=1;
		int j=1;
		int count=1;
		int sum=1;
		
		while (j!=n) {			
			if (sum == n) {
				count++;
				j++;
				sum += j;
			}
			else if(sum < n) {
				j++;
				sum += j;
			}
			else {
				sum -= i;
				i++;
			}
		}
		System.out.println(count);
		
	}

}
