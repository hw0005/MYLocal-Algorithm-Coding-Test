package Day261006.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 재료의 개수
		int m = Integer.parseInt(br.readLine()); // 갑옷 완성의 번호 합
		
		int[] d = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(d);
		
		int i = 0;
		int j = n-1;
		int count = 0;
		
		while (i<j) {
			if (d[i] + d[j] == m) {
				i++;
				j--;
				count++;
			}
			else if (d[i] + d[j] > m) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.println(count);
		
	}

}
