package Day261004.구간합복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 수 n개
		int m = Integer.parseInt(st.nextToken()); // 나머지 m
		
		int[] s = new int[n+1];
		int[] c = new int[m];
		
		st = new StringTokenizer(br.readLine());
		s[1] = Integer.parseInt(st.nextToken());
		for (int i=2; i<=n; i++) {
			s[i] = s[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i=1; i<=n; i++) {
			int remainder = s[i] % m;
			
			if (remainder == 0) {
				count++;
			}
			c[remainder]++;
		}
		
		for (int i=0; i<m; i++) {
			if (c[i] > 1) {
				count += c[i] *(c[i] - 1) / 2;
			}
		}
		System.out.println(count);
		
		
	}

}
