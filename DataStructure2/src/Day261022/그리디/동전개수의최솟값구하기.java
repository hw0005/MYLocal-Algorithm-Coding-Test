package Day261022.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전개수의최솟값구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 동전 수
		int m = Integer.parseInt(st.nextToken()); // 목표금액
		
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		
		int count = 0;
		
		for (int i=a.length - 1; i>=0; i--) {
			count = count + (m / a[i]);
			m = m % a[i];
		}
		System.out.println(count);
		
		
	}

}
