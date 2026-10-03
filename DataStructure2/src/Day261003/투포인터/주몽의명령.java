package Day261003.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 재료의 개수
		int m = Integer.parseInt(br.readLine()); // 번호의 합
		
		int[] s = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(s);
		int i = 0;
		int j = n-1;
		int count = 0;
		
		while (i < j) {
			if (s[i] + s[j] > m) {
				j--;
			}
			else if (s[i] + s[j] < m) {
				i++;
			}
			else {
				i++;
				j--;
				count++;
			}
		}
		
		System.out.println(count);
		
		
		
		
	}

}
