package Day261004.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 재료 수
		int m = Integer.parseInt(br.readLine()); // 갑옷 완성되는 번호 합
		
		int[] s = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n-1; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(s);
		
		int i = 0;
		int j = n-1;
		int count = 0;
		
		while (i<j) {
			if (s[i] + s[j] == m) {
				count++;
				j--;
				i++;
			}
			else if (s[i] + s[j] > m) {
				j--;
			}
			else {
				i++;
			}
		}
		
		System.out.println(count);
	}

}
