package Day261003.구간합복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 수 배열
		int m = Integer.parseInt(st.nextToken()); // 나누어 떨어지는 수
		
		int[] d = new int[n];
		int[] c = new int[m];
		
		st = new StringTokenizer(br.readLine());
		d[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<n; i++) {
			d[i] = Integer.parseInt(st.nextToken()) + d[i-1];
		}
		
		int count = 0;
		for (int i=0; i<n; i++) {
			int remainder = d[i] % m;
			
			if (remainder == 0) {
				count++;
			}
			
			c[remainder]++;
		}
		
		for (int i=0; i<m; i++) {
			if (c[i] > 1) {
				count += (c[i] *(c[i] - 1)) / 2;
			}
		}
		System.out.println(count);
		
		
		
	}

}
