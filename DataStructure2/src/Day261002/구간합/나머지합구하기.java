package Day261002.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 숫자 수
		int m = Integer.parseInt(st.nextToken()); // 나눠 떨어지는 수
		
		// 합배열 만들기
		int[] sArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<n; i++) {
			sArr[i] = sArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		//나머지합 만들기
		int[] c = new int[m];
		int count = 0;
		for (int i=0; i<n; i++) {
			int remainder = sArr[i] % m;
			
			if (remainder == 0) {
				count++;
			}
			c[remainder]++;
		}
		
		for (int i=0; i<m; i++) {
			if (c[i] > 0) {
				count += (c[i] * (c[i] - 1) / 2);
			}
		}
		
		System.out.println(count);

	}

}
