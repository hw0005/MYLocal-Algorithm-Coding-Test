package Day261006.구간합복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 수 갯수
		int m = Integer.parseInt(st.nextToken()); // 나누어 떨어지는 수
		
		int[] d = new int[n];
		int[] r = new int[m];
		
		st = new StringTokenizer(br.readLine());
		d[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<n; i++) {
			d[i] = d[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i=0; i<n; i++) {
			int remainder = d[i] % m;
			
			if (remainder == 0) {
				count++;
			}
			
			r[remainder]++;
		}
		
		for (int i=0; i<m; i++) {
			if (r[i] > 1) {
				count += r[i] * (r[i]-1) / 2;
			}
		}
		
		System.out.println(count);
	}

}
